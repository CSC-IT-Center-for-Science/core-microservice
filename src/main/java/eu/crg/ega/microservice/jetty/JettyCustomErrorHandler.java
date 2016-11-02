package eu.crg.ega.microservice.jetty;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.Base;

import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.server.Dispatcher;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.eclipse.jetty.util.log.Log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

@Log4j
public class JettyCustomErrorHandler extends ErrorHandler {

  //We cannot use HttpConversionService because the web context does not exist
  //private HttpConversionService httpConversionService;

  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request,
                     HttpServletResponse response) throws IOException {
    
    String method = request.getMethod();
    if (!method.equals(HttpMethod.GET) && !method.equals(HttpMethod.POST)
        && !method.equals(HttpMethod.HEAD)) {
      baseRequest.setHandled(true);
      return;
    }

    if (this instanceof ErrorPageMapper) {
      String error_page = ((ErrorPageMapper) this).getErrorPage(request);
      if (error_page != null && request.getServletContext() != null) {
        String old_error_page = (String) request.getAttribute(ERROR_PAGE);
        if (old_error_page == null || !old_error_page.equals(error_page)) {
          request.setAttribute(ERROR_PAGE, error_page);

          Dispatcher dispatcher =
              (Dispatcher) request.getServletContext().getRequestDispatcher(error_page);
          try {
            if (dispatcher != null) {
              dispatcher.error(request, response);
              return;
            }
            log.warn("No error page " + error_page);
          } catch (ServletException e) {
            log.warn(Log.EXCEPTION, e);
            return;
          }
        }
      }
    }

    baseRequest.setHandled(true);
    if (getCacheControl() != null) {
      response.setHeader(HttpHeader.CACHE_CONTROL.asString(), getCacheControl());
    }
    ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer(4096);
    Base<String>
        result =
        new Base<>(String.valueOf(baseRequest.getResponse().getStatus()),
            new Exception(baseRequest.getResponse()
                .getReason()));
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.writeValue(writer, result);
    } catch (IOException e) {
      log.error("Could not serialize exception");
      e.printStackTrace();
    }
    writer.flush();
    response.setContentLength(writer.size());
    writer.writeTo(response.getOutputStream());
    writer.destroy();
  }
}
