package eu.crg.ega.microservice.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.dto.version.GitRepositoryState;
import eu.crg.ega.microservice.dto.version.MavenEntry;
import eu.crg.ega.swaggerconstants.common.SwaggerVersion;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
@Api(value = "version-operations", description = SwaggerVersion.DESCRIPTION, position = 6)
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class VersionController {

  @ApiOperation(value = SwaggerVersion.GET_CORE_INFO, notes = SwaggerVersion.GET_CORE_INFO_NOTES)
  @RequestMapping(value = "/version/core", method = RequestMethod.GET)
  public Base<GitRepositoryState> getCoreVersion() {
    return getRepositoryState("core");
  }

  @ApiOperation(value = SwaggerVersion.GET_MICROSERVICE_INFO, notes = SwaggerVersion.GET_MICROSERVICE_INFO_NOTES)
  @RequestMapping(value = "/version", method = RequestMethod.GET)
  public Base<GitRepositoryState> getServiceVersion() throws IOException {
    return getRepositoryState("git");
  }

  private Base<GitRepositoryState> getRepositoryState(String filepreffix) {
    Properties properties = new Properties();
    try {
      properties.load(getClass().getClassLoader().getResourceAsStream(filepreffix + ".properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    GitRepositoryState gitRepositoryState = new GitRepositoryState(properties);
    return new Base<>(gitRepositoryState);
  }

  @ApiOperation(value = SwaggerVersion.GET_DEPENDENCIES_INFO, notes = SwaggerVersion.GET_DEPENDENCIES_INFO_NOTES)
  @RequestMapping(value = "/version/dependencies", method = RequestMethod.GET)
  public Base<MavenEntry> getServiceDependencies() throws IOException {

    Properties properties = new Properties();
    List<MavenEntry> mavenDependencies = null;
    try {
      properties.load(getClass().getClassLoader().getResourceAsStream(
          "META-INF/maven/dependencies.properties"));
      Map<String, MavenEntry> dictionary = new HashMap<String, MavenEntry>(101);
      for (Object key : properties.keySet()) {
        String[] parts = ((String) key).split("/");
        if (parts.length < 3) {
          continue;
        }
        String dictionarykey = parts[0] + "/" + parts[1];
        MavenEntry mavenEntry = dictionary.get(dictionarykey);
        if (mavenEntry == null) {// if null create a new object
          mavenEntry = MavenEntry.builder().group(parts[0]).name(parts[1]).build();
        }
        if ("version".equals(parts[2])) {
          mavenEntry.setVersion(properties.getProperty((String) key));
        } else if ("scope".equals(parts[2])) {
          mavenEntry.setScope(properties.getProperty((String) key));
        } else if ("type".equals(parts[2])) {
          mavenEntry.setType(properties.getProperty((String) key));
        }
        dictionary.put(dictionarykey, mavenEntry);
      }
      mavenDependencies = new ArrayList<>(dictionary.values());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new Base<>(mavenDependencies);
  }

}
