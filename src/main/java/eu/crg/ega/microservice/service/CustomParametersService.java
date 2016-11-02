package eu.crg.ega.microservice.service;


public interface CustomParametersService {

  /**
   * It returns the information to know if current request has the debug param
   */
  public boolean isDebugRequest();
}
