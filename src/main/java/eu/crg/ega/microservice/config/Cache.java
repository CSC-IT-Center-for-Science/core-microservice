package eu.crg.ega.microservice.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
@EnableCaching
public class Cache extends CachingConfigurerSupport {

  @Value("${service.cache.timeout}")
  private int cacheTimeout;

  @Value("${service.cache.size}")
  private int cacheSize;

  @Bean
  @Override
  public CacheManager cacheManager() {
    //Cache for saving the services urls
    GuavaCacheManager cacheManager = new GuavaCacheManager("serviceURL","serviceByVersionURL");
    cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(cacheTimeout, TimeUnit.MINUTES)
        .maximumSize(cacheSize));
    return cacheManager;
  }

  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    return new SimpleKeyGenerator();
  }

}
