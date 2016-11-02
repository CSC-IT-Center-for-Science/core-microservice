package eu.crg.ega.microservice.service;

import eu.crg.ega.microservice.dto.ServiceLocation;
import eu.crg.ega.microservice.enums.ServiceType;

import java.util.List;

public interface LocatorService {

  //Returns ServiceLocation objects

  /**
   * Get a list of all services of type type
   */
  public List<ServiceLocation> getServices(ServiceType type);

  /**
   * Get a list of all services of type type and version version
   */
  public List<ServiceLocation> getServices(ServiceType type, String version);

  /**
   * Returns first service of type type
   */
  public ServiceLocation getService(ServiceType type);

  /**
   * Returns first service of type type and version version
   */
  public ServiceLocation getService(ServiceType type, String version);

  // Return urls

  /**
   * Returns first url of service of type type
   */
  public String getServiceUrl(ServiceType type);

  /**
   * Returns first url of service of type type and version version
   */
  public String getServiceUrl(ServiceType type, String version);

  /**
   * Returns first url of service with the serviceId
   */
  public String getServiceUrlById(String serviceId);

  /**
   * Returns list of  url of service of type type
   */
  public List<String> getServicesUrl(ServiceType type);

  /**
   * Returns list of  url of service of type type and version version
   */
  public List<String> getServicesUrl(ServiceType type, String version);

  /**
   * Deletes cache of serviceLocations
   */
  public void resetAllEntries();

}
