package eu.crg.ega.microservice.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import eu.crg.ega.microservice.ApplicationContextProvider;
import eu.crg.ega.microservice.rest.RestErrorHandler;
import eu.crg.ega.microservice.interceptor.CorrelationIdInterceptor;
import eu.crg.ega.microservice.interceptor.CustomClientAddressInterceptor;
import eu.crg.ega.microservice.interceptor.CustomTokenInterceptor;
import eu.crg.ega.microservice.interceptor.LogRestInterceptor;
import eu.crg.ega.microservice.security.MySessionToken;

@Configuration
//@Import({Cache.class, RabbitMq.class, Swagger.class, Web.class})
public class App {

  @Bean
  public ApplicationContextProvider applicationContextProvider() {
    return new eu.crg.ega.microservice.ApplicationContextProvider();
  }

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    // This module serializes/deserializes DateTime values using the milliseconds form
    objectMapper.registerModule(new JodaModule());
    return objectMapper;
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
    if (messageConverters == null) {
      messageConverters = new ArrayList<HttpMessageConverter<?>>();
    }
    boolean found = false;
    for (HttpMessageConverter<?> converter : messageConverters) {
      if (converter instanceof MappingJackson2HttpMessageConverter) {
        found = true;
        // To ensure that the Jackson converter uses an object mapper with Joda module
        ((MappingJackson2HttpMessageConverter) converter).setObjectMapper(objectMapper());
      }
    }
    if (!found) {
      messageConverters.add(addJacksonConverter());
    }
    restTemplate.setErrorHandler(new RestErrorHandler());
    addInterceptors(restTemplate);
    return restTemplate;
  }

  private MappingJackson2HttpMessageConverter addJacksonConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper());
    return converter;
  }

  private void addInterceptors(RestTemplate restTemplate) {
    List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
    interceptors.add(new CustomClientAddressInterceptor());
    interceptors.add(new CustomTokenInterceptor());
    interceptors.add(new CorrelationIdInterceptor());
    interceptors.add(new LogRestInterceptor());
    restTemplate.setInterceptors(interceptors);
  }

  /**
   * This bean is used for storing the service's system user token.
   */
  @Bean
  public MySessionToken mySessionToken() {
    return new MySessionToken(null);
  }

}
