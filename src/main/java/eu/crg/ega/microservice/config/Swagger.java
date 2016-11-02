package eu.crg.ega.microservice.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.ordering.ResourceListingPositionalOrdering;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger
public class Swagger {

  private SpringSwaggerConfig springSwaggerConfig;

  @Value("${swagger.host}")
  private String swaggerHost;

  @Value("${swagger.context.path}")
  private String swaggerContextPath;

  @Autowired
  public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
    this.springSwaggerConfig = springSwaggerConfig;
  }

  @Bean
  // Don't forget the @Bean annotation
  public SwaggerSpringMvcPlugin customImplementation() {

    return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
        .pathProvider(new CustomSwaggerPathProvider(swaggerHost, swaggerContextPath))
        .apiInfo(apiInfo())
        .includePatterns("/.*")
        .directModelSubstitute(DateTime.class, String.class)
        .apiListingReferenceOrdering(new ResourceListingPositionalOrdering());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo =
        new ApiInfo("Microservice API", "Provides microservices api",
                    "https://ega.crg.eu/rest-terms", "webmaster.ega@crg.eu", "License",
                    "https://ega.crg.eu/rest-license");
    return apiInfo;
  }

}
