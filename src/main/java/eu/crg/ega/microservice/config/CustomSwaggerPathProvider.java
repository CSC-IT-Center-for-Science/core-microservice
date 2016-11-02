package eu.crg.ega.microservice.config;

import com.mangofactory.swagger.paths.SwaggerPathProvider;

import org.springframework.web.util.UriComponentsBuilder;

public class CustomSwaggerPathProvider extends SwaggerPathProvider {

  private String swaggerHost;

  private String swaggerContextPath;

  public CustomSwaggerPathProvider(String swaggerHost, String swaggerContextPath) {
    this.swaggerHost = swaggerHost;
    this.swaggerContextPath = swaggerContextPath;
  }

  @Override
  protected String applicationPath() {
    return UriComponentsBuilder
        .fromHttpUrl(swaggerHost)
        .path(swaggerContextPath)
        .build()
        .toString();
  }

  @Override
  protected String getDocumentationPath() {
    return UriComponentsBuilder
        .fromHttpUrl(applicationPath())
        .pathSegment("api-docs/")
        .build().toString();
  }

}
