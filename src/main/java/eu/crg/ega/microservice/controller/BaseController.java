package eu.crg.ega.microservice.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import eu.crg.ega.microservice.constant.CoreConstants;
import eu.crg.ega.microservice.constant.ParamName;
import eu.crg.ega.microservice.controller.interfaces.Basic;
import eu.crg.ega.microservice.controller.interfaces.Instrumentation;
import eu.crg.ega.microservice.controller.interfaces.Log;
import eu.crg.ega.microservice.controller.interfaces.Metrics;
import eu.crg.ega.microservice.controller.interfaces.RestEventListener;
import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.dto.message.ServiceMessage;
import eu.crg.ega.microservice.enums.CacheTypes;
import eu.crg.ega.microservice.enums.ServiceAction;
import eu.crg.ega.microservice.enums.Status;
import eu.crg.ega.microservice.exception.NotImplementedException;
import eu.crg.ega.microservice.service.AppService;
import eu.crg.ega.microservice.service.LocatorService;
import eu.crg.ega.microservice.service.LogService;
import eu.crg.ega.swaggerconstants.common.SwaggerBase;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Arrays;

@Api(value = "base-operations", description = SwaggerBase.DESCRIPTION, position = 6)
// @RestController
// Technically speaking this annotation is no needed, it is used for documentation purposes
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SYSTEM')")
public abstract class BaseController implements Instrumentation, Metrics, Log, RestEventListener, Basic {

  private static final String NOT_IMPLEMENTED = "Not implemented";
  private static final String ERROR_LEVEL_NOT_EXISTS = "The level does not exist";

  @Autowired
  private LogService logService;

  @Autowired
  private AppService appService;

  @Autowired
  private LocatorService locatorService;

  // LOG
  @Override
  @ApiOperation(value = SwaggerBase.SET_LOG_LEVEL, notes = SwaggerBase.SET_LOG_LEVEL_NOTES)
  @RequestMapping(value = "/logs", method = RequestMethod.PUT)
  public Base<String> setLogLevel(
      @ApiParam(name = ParamName.LEVEL, value = SwaggerBase.SET_LOG_LEVEL_VALUE, required = true)
      @RequestParam(value = ParamName.LEVEL, required = true) String level) {
    try {
      logService.setLoglevel(level);
    } catch (LogLevelFormatException e) {
      throw new RuntimeException(ERROR_LEVEL_NOT_EXISTS);
    }
    return new Base<>(level);
  }

  @Override
  @RequestMapping(value = "/logs/{classname}", method = RequestMethod.PUT)
  public Base<String> setLogLevelForClass(
      @PathVariable(value = "classname") String classname,
      @ApiParam(name = "level", value = SwaggerBase.SET_LOG_LEVEL_VALUE, required = true)
      @RequestParam(value = "level", required = true) String level) {
    try {
      logService.setLoglevel(classname, level);
    } catch (LogLevelFormatException e) {
      throw new RuntimeException(ERROR_LEVEL_NOT_EXISTS);
    }
    return new Base<>(level);
  }

  @Override
  @ApiOperation(value = SwaggerBase.GET_LOG_LEVEL, notes = SwaggerBase.GET_LOG_LEVEL_NOTES)
  @RequestMapping(value = "/logs/level", method = RequestMethod.GET)
  public Base<String> getLogLevel() {
    return new Base<>(logService.getLoglevel().toString());
  }

  @Override
  @ApiOperation(value = SwaggerBase.LEVELS, notes = SwaggerBase.LEVELS_NOTES)
  @RequestMapping(value = "/logs/levels", method = RequestMethod.GET)
  public Base<String> getLogLevels() {
    return new Base<>(logService.getLoglevels().toString());
  }

  // INSTRUMENTATION
  private Base<String> insStart() {
    appService.setStatus(Status.STARTED);
    return new Base<>(appService.getStatus().toString());
  }

  private Base<String> insStop() {
    if (appService.getContext() == null) {
      return new Base<>("No Context to stop");
    }
    try {
      appService.setStatus(Status.STOPPING);
      return new Base<>(Status.STOPPING.toString());
    } finally {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(500L);
          } catch (InterruptedException ex) {
            // Swallow exception and continue
          }
          appService.stop();
        }
      }).start();
    }
  }

  private Base<String> insPause() {
    appService.setStatus(Status.PAUSED);
    return new Base<>(appService.getStatus().toString());
  }

  private Base<String> insReload() {
    throw new NotImplementedException(NOT_IMPLEMENTED);
  }

  @Override
  @ApiOperation(value = SwaggerBase.GET_STATUS, notes = SwaggerBase.GET_STATUS_NOTES)
  @RequestMapping(value = "/status", method = RequestMethod.GET)
  public Base<String> getStatus() {
    return new Base<>(appService.getStatus().toString());
  }

  @Override
  @ApiOperation(value = SwaggerBase.GET_STATUS_STATES, notes = SwaggerBase.GET_STATUS_STATES_NOTES)
  @RequestMapping(value = "/status/states", method = RequestMethod.GET)
  public Base<String> getStatusStates() {
    return new Base<>(Arrays.asList(Status.values()).toString());
  }

  @Override
  @ApiOperation(value = SwaggerBase.SET_STATUS, notes = SwaggerBase.SET_STATUS_NOTES)
  @RequestMapping(value = "/status", method = RequestMethod.PUT)
  public Base<String> setStatus(
      @ApiParam(name = ParamName.VALUE, value = SwaggerBase.SET_STATUS_VALUE, required = true)
      @RequestParam(value = ParamName.VALUE) String action) {
    ServiceAction serviceAction = ServiceAction.parse(action);
    switch (serviceAction) {
      case START:
        return insStart();
      case STOP:
        return insStop();
      case PAUSE:
        return insPause();
      case RELOAD:
        return insReload();
      default:
        throw new NotImplementedException(NOT_IMPLEMENTED);
    }
  }

  @Override
  @ApiOperation(value = SwaggerBase.GET_COMMANDS, notes = SwaggerBase.GET_COMMANDS_NOTES)
  @RequestMapping(value = "/status/commands", method = RequestMethod.GET)
  public Base<ServiceAction> getCommands() {
    return new Base<>(Arrays.asList(ServiceAction.values()));
  }

  @Override
  @RequestMapping(value = "/cache", method = RequestMethod.DELETE)
  public Base<String> deleteCache(@RequestParam(value = ParamName.CACHE_TYPE, required = true) String cacheName) {
    CacheTypes cacheNameParsed = CacheTypes.parse(cacheName);
    switch (cacheNameParsed) {
      case SERVICE_LOCATION:
        locatorService.resetAllEntries();
        break;
      default:
        break;
    }
    return new Base<>(CoreConstants.OK);
  }

  // EVENTS
  @Override
  @ApiOperation(value = SwaggerBase.EVENTS, notes = SwaggerBase.EVENTS_NOTES)
  @RequestMapping(value = "/events", method = RequestMethod.POST)
  public Base<String> receive(ServiceMessage message) throws JsonParseException,
      JsonMappingException, IOException {

    throw new NotImplementedException(NOT_IMPLEMENTED);
  }

  // METRICS
  @Override
  @ApiOperation(value = SwaggerBase.RESET, notes = SwaggerBase.RESET_NOTES)
  @RequestMapping(value = "/metrics/ega/reset", method = RequestMethod.PUT)
  public Base<String> reset() {
    throw new NotImplementedException(NOT_IMPLEMENTED);
  }

  @Override
  @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
  public Base<String> hello(
      @PathVariable(value = "message") String message
  ) {
    if (StringUtils.isBlank(message)) {
      message = "hello";
    }
    return new Base<>(String.valueOf(message.hashCode()));
  }
}
