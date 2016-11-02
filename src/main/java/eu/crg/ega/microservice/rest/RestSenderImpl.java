package eu.crg.ega.microservice.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.enums.ServiceType;
import eu.crg.ega.microservice.exception.PreConditionFailed;
import eu.crg.ega.microservice.exception.RestRuntimeException;
import eu.crg.ega.microservice.exception.ServerDownException;
import eu.crg.ega.microservice.helper.CommonQuery;
import eu.crg.ega.microservice.helper.CommonQueryHelper;
import eu.crg.ega.microservice.service.LocatorService;

@Component
public class RestSenderImpl implements RestSender {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LocatorService locatorService;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public String send(String dest, HttpMethod method, HttpHeaders headers) {

    return send(dest, method, null, null, headers, String.class);
  }

  @Override
  public <T> T send(String url, HttpMethod method, MultiValueMap<String, String> params,
                    MultiValueMap<String, String> urlParams, HttpHeaders headers, Class<T> typeclass) {

    if (headers == null) {
      headers = new HttpHeaders();
    }
    
    url = convertUrlParamsToQueryString(url, urlParams);

    HttpEntity<MultiValueMap<String, String>> request =
        new HttpEntity<MultiValueMap<String, String>>(params, headers);

    ResponseEntity<T> response = null;
    try {
      response = restTemplate.exchange(url, method, request, typeclass);
    } catch (ResourceAccessException e) {
      throw new ServerDownException(e.getMessage());
    }
    return response.getBody();
  }

  @Override
  public <T> T sendSpecificInstance(String serviceId, String partialUrl, HttpMethod method,
      MultiValueMap<String, String> params, HttpHeaders headers, Class<T> typeclass) {

    String initalUrl = locatorService.getServiceUrlById(serviceId);
    String url = initalUrl + partialUrl;

    T response = send(url, method, params, null, headers, typeclass);
    return response;
  }
  
  @Override
  public <T> T send(ServiceType serviceType, String partialUrl, HttpMethod method,
      MultiValueMap<String, String> params, MultiValueMap<String, String> urlParams,
      HttpHeaders headers, Class<T> typeclass) {

    String initalUrl = locatorService.getServiceUrl(serviceType);
    String url = initalUrl + partialUrl;

    T response = send(url, method, params, urlParams, headers, typeclass);
    return response;
  }

  @Override
  public <T> T send(ServiceType serviceType, String version, String partialUrl, HttpMethod method,
      MultiValueMap<String, String> params, MultiValueMap<String, String> urlParams,
      HttpHeaders headers, Class<T> typeclass) {

    String initalUrl = null;
    if (StringUtils.isNotBlank(version)) {
      if (!Pattern.matches("v\\d*", version)) {
        throw new PreConditionFailed("Invalid value for version: " + version);
      }
      initalUrl = locatorService.getServiceUrl(serviceType, version);
    } else {
      initalUrl = locatorService.getServiceUrl(serviceType);
    }
    String url = initalUrl + partialUrl;

    T response = send(url, method, params, urlParams, headers, typeclass);
    return response;
  }
  
  @Override
  public <T> T send(ServiceType serviceType, String partialUrl, HttpMethod method,
      Class<T> typeclass) {

    return send(serviceType, partialUrl, method, null, null, null, typeclass);
  }

  @Override
  public <T, V, Y, Z> List<T> sendMicroserviceObject(ServiceType serviceType, String partialUrl,
                                                     HttpMethod method, V params,
                                                     MultiValueMap<Y, Z> urlParams,
                                                     HttpHeaders headers,
                                                     Class<T> typeclass, boolean isJsonObject) {

    Base<T> basicDTO =
        sendMicroservice(serviceType, partialUrl, method, params, urlParams, headers, typeclass,
                         isJsonObject);

    if (basicDTO != null && basicDTO.getResponse() != null
        && basicDTO.getResponse().getResult() != null) {
      return basicDTO.getResponse().getResult();
    } else {
      return null;
    }
  }

  @Override
  public <T> List<T> sendMicroserviceObject(ServiceType serviceType, String partialUrl,
      HttpMethod method, Class<T> typeclass) {

    return sendMicroserviceObject(serviceType, partialUrl, method, null, null, null, typeclass,
        false);
  }

  @Override
  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
                                               HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, boolean isJsonObject) {

    String initalUrl = locatorService.getServiceUrl(serviceType);
    String url = initalUrl + partialUrl;

    Base<T> basicDTO =
        sendMicroservice(url, method, params, urlParams, headers, typeclass, isJsonObject);

    return basicDTO;
  }

  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String version,
      String partialUrl, HttpMethod method, V params, MultiValueMap<Y, Z> urlParams,
      HttpHeaders headers, Class<T> typeclass, boolean isJsonObject) {

    String initalUrl = null;
    if(StringUtils.isNotBlank(version)) {
      if(!Pattern.matches("v\\d*", version)) {
        throw new PreConditionFailed("Invalid value for version: " + version);
      }
      initalUrl = locatorService.getServiceUrl(serviceType, version);  
    } else {
      initalUrl = locatorService.getServiceUrl(serviceType);
    }
    String url = initalUrl + partialUrl;

    Base<T> basicDTO =
        sendMicroservice(url, method, params, urlParams, headers, typeclass, isJsonObject);

    return basicDTO;
  }

  @Override
  public <T, V, Y, Z> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
                                               HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, MediaType contentType,
                                               MediaType acceptType) {
    String initalUrl = locatorService.getServiceUrl(serviceType);
    String url = initalUrl + partialUrl;

    Base<T> basicDTO =
        sendMicroservice(url, method, params, urlParams, headers, typeclass, contentType,
                         acceptType);

    return basicDTO;
  }

  @Override
  public <T, V, Y, Z> Base<T> sendMicroservice(String url, HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, boolean isJsonObject) {

    MediaType contentType = null;
    if (isJsonObject) {
      contentType = MediaType.APPLICATION_JSON;
    }

    Base<T> basicDTO =
        sendMicroservice(url, method, params, urlParams, headers, typeclass, contentType, null);

    return basicDTO;
  }

  @Override
  public <T, V, Y, Z> Base<T> sendMicroservice(String url, HttpMethod method, V params,
                                               MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
                                               Class<T> typeclass, MediaType contentType,
                                               MediaType acceptType) {

    if (headers == null) {
      headers = new HttpHeaders();
    }

    if (contentType != null) {
      headers.setContentType(contentType);
    }

    if (acceptType != null) {
      ArrayList<MediaType> list = new ArrayList<MediaType>();
      list.add(MediaType.APPLICATION_JSON);
      headers.setAccept(list);
    }

    url = convertUrlParamsToQueryString(url, urlParams);

    HttpEntity<V> request = new HttpEntity<V>(params, headers);
    ResponseEntity<String> response = null;
    try {
      response = restTemplate.exchange(url, method, request, String.class);
    } catch (ResourceAccessException e) {
      throw new ServerDownException(e.getMessage());
    }

    JavaType type = objectMapper.getTypeFactory().constructParametricType(Base.class, typeclass);
    Base<T> basicDTO = null;
    try {
      basicDTO = objectMapper.readValue(response.getBody(), type);
    } catch (IOException e) {
      throw new RestRuntimeException("500", "Exception deserializing object: " + response.getBody()
                                            + "\n" + e.getMessage());
    }

    return basicDTO;
  }

  private <Y, Z> String convertUrlParamsToQueryString(String url, MultiValueMap<Y, Z> urlParams) {
    if (urlParams != null) {
      String queryString = "";
      for (Entry<Y, List<Z>> urlParam : urlParams.entrySet()) {
        if (queryString.length() > 0) {
          queryString += "&";
        }
        queryString += urlParam.getKey() + "=" + urlParam.getValue().get(0);
      }
      url += "?" + queryString;
    }
    return url;
  }

  @Override
  public <T> Base<T> sendMicroservice(ServiceType serviceType, String partialUrl,
      HttpMethod method, Class<T> typeclass) {

    CommonQuery commonQuery = CommonQuery.builder().limit(0).skip(0).build();
    return sendMicroservice(serviceType, partialUrl, method, null,
        CommonQueryHelper.toMap(commonQuery), null, typeclass, false);
  }

  @Override
  public <T, V, Y, Z> Base<T> sendMicroserviceSpecificInstance(String serviceId, String partialUrl,
      HttpMethod method, V params, MultiValueMap<Y, Z> urlParams, HttpHeaders headers,
      Class<T> typeclass, boolean isJsonObject) {

    String initalUrl = locatorService.getServiceUrlById(serviceId);
    String url = initalUrl + partialUrl;

    Base<T> basicDTO =
        sendMicroservice(url, method, params, urlParams, headers, typeclass, isJsonObject);

    return basicDTO;
  }

  @Override
  public <T> Base<T> sendMicroserviceSpecificInstance(String serviceId, String partialUrl,
      HttpMethod method, Class<T> typeclass) {

    return sendMicroserviceSpecificInstance(serviceId, partialUrl, method, null, null, null,
        typeclass, false);
  }
  
}
