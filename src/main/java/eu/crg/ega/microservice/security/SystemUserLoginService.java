package eu.crg.ega.microservice.security;


public interface SystemUserLoginService {

  public void addSystemUserToContext();

  public void addSystemUserToContext(boolean updateSystemUserSession);

}
