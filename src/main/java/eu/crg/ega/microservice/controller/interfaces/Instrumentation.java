package eu.crg.ega.microservice.controller.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import eu.crg.ega.microservice.constant.ParamName;
import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.enums.ServiceAction;
import eu.crg.ega.swaggerconstants.common.SwaggerBase;

@RestController
// Can't use this because the BaseController class implements all the interfaces
// @RequestMapping("/status")
public interface Instrumentation {

  @ApiOperation(value = SwaggerBase.GET_STATUS, notes = SwaggerBase.GET_STATUS_NOTES)
  @RequestMapping(value = "/status", method = RequestMethod.GET)
  public Base<String> getStatus();

  @ApiOperation(value = SwaggerBase.SET_STATUS, notes = SwaggerBase.SET_STATUS_NOTES)
  @RequestMapping(value = "/status", method = RequestMethod.PUT)
  public Base<String> setStatus(
      @ApiParam(name = "value", value = SwaggerBase.SET_STATUS_VALUE, required = true)
      @RequestParam(value = "value") String action);

  @ApiOperation(value = SwaggerBase.GET_STATUS_STATES, notes = SwaggerBase.GET_STATUS_STATES_NOTES)
  @RequestMapping(value = "/status/states", method = RequestMethod.GET)
  public Base<String> getStatusStates();

  @ApiOperation(value = SwaggerBase.GET_COMMANDS, notes = SwaggerBase.GET_COMMANDS_NOTES)
  @RequestMapping(value = "/status/commands", method = RequestMethod.GET)
  public Base<ServiceAction> getCommands();
  
  @ApiOperation(value = SwaggerBase.DELETE_CACHE, notes = SwaggerBase.DELETE_CACHE_NOTES)
  @RequestMapping(value = "/cache", method = RequestMethod.DELETE)
  public Base<String> deleteCache(
      @ApiParam(name = ParamName.CACHE_TYPE, value = SwaggerBase.DELETE_CACHE_NAME, required = true)
      @RequestParam(value = ParamName.CACHE_TYPE, required = true) String cacheName);
  
}
