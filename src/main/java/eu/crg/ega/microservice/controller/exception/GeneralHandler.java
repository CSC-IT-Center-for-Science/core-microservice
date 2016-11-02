package eu.crg.ega.microservice.controller.exception;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.exception.CookieNotFoundException;
import eu.crg.ega.microservice.exception.NotFoundException;
import eu.crg.ega.microservice.exception.NotImplementedException;
import eu.crg.ega.microservice.exception.PreConditionFailed;
import eu.crg.ega.microservice.exception.RestRuntimeException;
import eu.crg.ega.microservice.exception.ServerDownException;
import eu.crg.ega.microservice.exception.ServiceUnavailableException;
import eu.crg.ega.microservice.exception.SessionAlreadyClosed;
import eu.crg.ega.microservice.exception.SessionInvalidException;
import eu.crg.ega.microservice.exception.SessionTimedOutException;
import eu.crg.ega.microservice.exception.UnauthorizedException;
import eu.crg.ega.microservice.service.CustomParametersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class GeneralHandler {

  @Autowired
  CustomParametersService customParametersService;

  //Generic
  @ExceptionHandler
  @ResponseBody
  public Base<String> handleException(Exception ex, HttpServletResponse response) {

    response.setStatus(HttpStatus.BAD_REQUEST.value());
    int statusCode = HttpServletResponse.SC_BAD_REQUEST;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler({CookieNotFoundException.class, UnauthorizedException.class,
                     SessionTimedOutException.class, SessionInvalidException.class})
  @ResponseBody
  public Base<String> requestBindingException(Exception ex, HttpServletResponse response) {

    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    int statusCode = HttpServletResponse.SC_UNAUTHORIZED;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler(RestRuntimeException.class)
  @ResponseBody
  public Base<String> requestBindingException(RestRuntimeException ex,
                                              HttpServletResponse response) {

    int statusCode = 400;
    try {
      statusCode = Integer.parseInt(ex.getCode());
    } catch (NumberFormatException exception) {

    }
    response.setStatus(statusCode);

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public Base<String> requestBindingException(NotFoundException ex, HttpServletResponse response) {

    response.setStatus(HttpStatus.NOT_FOUND.value());
    int statusCode = HttpServletResponse.SC_NOT_FOUND;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler(PreConditionFailed.class)
  @ResponseBody
  public Base<String> requestBindingException(PreConditionFailed ex, HttpServletResponse response) {

    response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
    int statusCode = HttpServletResponse.SC_PRECONDITION_FAILED;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler({ServerDownException.class, ServiceUnavailableException.class})
  @ResponseBody
  public Base<String> unavailableException(Exception ex, HttpServletResponse response) {

    response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
    int statusCode = HttpServletResponse.SC_SERVICE_UNAVAILABLE;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler(SessionAlreadyClosed.class)
  @ResponseBody
  public Base<String> requestBindingException(SessionAlreadyClosed ex,
                                              HttpServletResponse response) {

    response.setStatus(HttpStatus.GONE.value());
    int statusCode = HttpServletResponse.SC_GONE;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }

  @ExceptionHandler(NotImplementedException.class)
  @ResponseBody
  public Base<String> requestBindingException(NotImplementedException ex,
                                              HttpServletResponse response) {

    response.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
    int statusCode = HttpServletResponse.SC_NOT_IMPLEMENTED;

    log.error("Exception: " + ex.toString(), ex);
    return new Base<String>(String.valueOf(statusCode), ex, customParametersService.isDebugRequest());
  }
}
