package eu.crg.ega.microservice.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

public class RestWebAuthenticationDetailsSource extends WebAuthenticationDetailsSource {

  @Override
  public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
    return new RestWebAuthenticationDetails(context);
  }

}
