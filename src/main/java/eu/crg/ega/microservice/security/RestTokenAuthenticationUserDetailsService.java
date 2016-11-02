package eu.crg.ega.microservice.security;

import eu.crg.ega.microservice.constant.CoreConstants;
import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.dto.auth.SessionUser;
import eu.crg.ega.microservice.enums.ServiceType;
import eu.crg.ega.microservice.rest.RestSender;
import eu.crg.ega.microservice.exception.RestRuntimeException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class RestTokenAuthenticationUserDetailsService
    implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

  @Autowired
  private RestSender restSender;

  @Override
  public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token)
      throws UsernameNotFoundException {

    HttpHeaders httpHeaders = new HttpHeaders();
    String sessionToken = token.getPrincipal().toString();
    if (StringUtils.isNotBlank(sessionToken)) {
      httpHeaders.add(CoreConstants.TOKEN_HEADER, sessionToken);
    } else {
      System.out.println("SessionToken is empty");
    }

    try {
      final Base<SessionUser>
          returnedSessionUser =
          restSender.sendMicroservice(ServiceType.SESSION,
                                           "/sessions/" + sessionToken,
                                           HttpMethod.GET, null, null, httpHeaders,
                                           SessionUser.class,
                                           false);
      SessionUser sessionUser = returnedSessionUser.getResponse().getResult().get(0);
      if (returnedSessionUser == null || returnedSessionUser.getHeader() == null
          || Integer.parseInt(returnedSessionUser.getHeader().getCode()) != HttpStatus.OK.value()
          || returnedSessionUser.getResponse() == null
          || returnedSessionUser.getResponse().getResult() == null
          || returnedSessionUser.getResponse().getResult().size() != 1
          || sessionUser.getUser() == null) {
        throw new UsernameNotFoundException("Username not found");
      }
      return sessionUser.getUser();
    } catch (Exception e) {
      if (e instanceof RestRuntimeException) {
        throw new UsernameNotFoundException(e.getMessage());
      }
    }
    throw new UsernameNotFoundException("User not found");
  }

}
