package eu.crg.ega.microservice.config;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eu.crg.ega.microservice.converter.CustomBeanUtilsBean;
import eu.crg.ega.microservice.converter.DatetimeToTimestampConverter;
import eu.crg.ega.microservice.converter.TimestampToDatetimeConverter;
import eu.crg.ega.microservice.filter.CorrelationHeaderFilter;
import eu.crg.ega.microservice.filter.CustomClientAddressFilter;
import eu.crg.ega.microservice.filter.LogRequestFilter;
import eu.crg.ega.microservice.filter.LowercaseRequestParamsFilter;

@Configuration
public class WebInitializer implements ServletContextInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    // This method adds a Filter to our Servlet so it "intercepts" the servlets calls
    // and if an action method is found, it translate the httpRequest

    CustomClientAddressFilter xForwardedForFilter = new CustomClientAddressFilter();
    servletContext.addFilter("customXForwardedForFilter", xForwardedForFilter)
        .addMappingForUrlPatterns(null, true, "/*");

    LogRequestFilter logRequestFilter = new LogRequestFilter();
    servletContext.addFilter("logRequestFilter", logRequestFilter).addMappingForUrlPatterns(null,
        true, "/*");

    LowercaseRequestParamsFilter lowercaseRequestParamsFilter = new LowercaseRequestParamsFilter();
    servletContext.addFilter("lowercaseRequestParamsFilter", lowercaseRequestParamsFilter)
        .addMappingForUrlPatterns(null, true, "/*");

    // Set Joda's DateTime default time zone to UTC
    DateTimeZone.setDefault(DateTimeZone.UTC);

    //Register CustomBeanUtilsBean
    BeanUtilsBean.setInstance(new CustomBeanUtilsBean());
    //Register typeConverter
    TimestampToDatetimeConverter timestampToDatetimeConverter = new TimestampToDatetimeConverter();
    ConvertUtils.register(timestampToDatetimeConverter, DateTime.class);
    DatetimeToTimestampConverter datetimeToTimestampConverter = new DatetimeToTimestampConverter();
    ConvertUtils.register(datetimeToTimestampConverter, Timestamp.class);
  }

  //Register correlationId filter
  @Bean
  public FilterRegistrationBean correlationHeaderFilter() {
    FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
    filterRegBean.setFilter(new CorrelationHeaderFilter());
    filterRegBean.setUrlPatterns(Arrays.asList("/*"));
    return filterRegBean;
  }

}