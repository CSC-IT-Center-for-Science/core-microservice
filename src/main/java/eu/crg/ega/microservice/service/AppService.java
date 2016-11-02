package eu.crg.ega.microservice.service;

import eu.crg.ega.microservice.enums.Status;

import org.springframework.context.ApplicationContext;

public interface AppService {

  /**
   * Performs reload action on the microservice. By default it refreshes context
   */
  public void reload();

  /**
   * Performs stop action on the microservice. By default it stops the microservice
   */
  public void stop();

  /**
   * Performs get status action on the microservice. By default it returns the current status
   */
  public Status getStatus();

  /**
   * Performs set status action on the microservice. By default it just changes the status
   */
  public void setStatus(Status status);

  /**
   * Returns current contect of the microservice
   */
  public ApplicationContext getContext();

}
