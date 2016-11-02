package eu.crg.ega.microservice.rest;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.enums.ServiceType;
import eu.crg.ega.microservice.interfaces.Sender;


public interface RestSender extends Sender<String, HttpMethod, HttpHeaders> {

  /**
   * @param urlParams TODO
   */
  public <T> T send(String url, HttpMethod method, MultiValueMap<String, String> params,
                    MultiValueMap<String, String> urlParams, HttpHeaders headers, Class<T> type);

  public <T> T sendSpecificInstance(String serviceId, String partialUrl, HttpMethod method,
                                    MultiValueMap<String, String> params, HttpHeaders headers, Class<T> type);

  public <T> T send(ServiceType serviceType, String partialUrl, HttpMethod method,
                    MultiValueMap<String, String> params, MultiValueMap<String, String> urlParams,
                    HttpHeaders headers, Class<T> typeclass);

  public <T> T send(ServiceType serviceType, String version, String partialUrl, HttpMethod method,
                    MultiValueMap<String, String> params, MultiValueMap<String, String> urlParams,
                    HttpHeaders headers, Class<T> typeclass);

  public <T> T send(ServiceType serviceType, String partialUrl, HttpMethod method,
                    Class<T> typeclass);

  /**
   * This short signature sends a CommonQuery object with skip=0 and limit=0;
   */
  public <T> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
                                      HttpMethod method, Class<T> typeclass);

  /**
   * @param params       : parameters sent in the body.
   * @param urlParams    : parameters that must be send in the URL.
   * @param isJsonObject : true if params is a JSON object; false otherwise.
   */

  public <T, V, Y, Z> Base<T> sendMicroservice(String url, HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers, Class<T> typeclass, boolean isJsonObject);

  public <T, V, Y, Z> Base<T> sendMicroservice(String url, HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers, Class<T> typeclass,
                                               MediaType contentType, MediaType acceptType);

  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
                                               HttpMethod method, V params, MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, boolean isJsonObject);

  /**
   * @param version: version of the microservice (e.g. v2).
   */
  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String version,
                                               String partialUrl, HttpMethod method, V params, MultiValueMap<Y, Z> urlParams,
                                               HttpHeaders headers, Class<T> typeclass, boolean isJsonObject);

  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
                                               HttpMethod method, V params, MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, MediaType contentType, MediaType acceptType);

  public <T, V, Y, Z> List<T> sendMicroserviceObject(ServiceType serviceType, String partialUrl,
                                                     HttpMethod method, V params, MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                                     Class<T> typeclass, boolean isJsonObject);

  public <T> List<T> sendMicroserviceObject(ServiceType serviceType, String partialUrl,
                                            HttpMethod method, Class<T> typeclass);

  /**
   * Rest call to a specific instance of one service.
   *
   * @param serviceId : serviceId of that instance
   */
  public <T, V, Y, Z> Base<T> sendMicroserviceSpecificInstance(String serviceId, String partialUrl,
                                                               HttpMethod method, V params, MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                                               Class<T> typeclass, boolean isJsonObject);

  public <T> Base<T> sendMicroserviceSpecificInstance(String serviceId, String partialUrl,
                                                      HttpMethod method, Class<T> typeclass);

}
