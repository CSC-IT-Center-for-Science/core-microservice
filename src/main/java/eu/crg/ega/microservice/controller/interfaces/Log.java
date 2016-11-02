package eu.crg.ega.microservice.controller.interfaces;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.swaggerconstants.common.SwaggerBase;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Can't use this because the BaseController class implements all the interfaces
// @RequestMapping("/logs")
public interface Log {

  @ApiOperation(value = SwaggerBase.SET_LOG_LEVEL, notes = SwaggerBase.SET_LOG_LEVEL_NOTES)
  @RequestMapping(value = "/logs", method = RequestMethod.PUT)
  public Base<String> setLogLevel(
      @ApiParam(name = "level", value = SwaggerBase.SET_LOG_LEVEL_VALUE, required = true)
      @RequestParam(value = "level", required = true) String level);

  @RequestMapping(value = "/logs/{classname}", method = RequestMethod.PUT)
  public Base<String> setLogLevelForClass(
      @PathVariable(value = "classname") String classname,
      @ApiParam(name = "level", value = SwaggerBase.SET_LOG_LEVEL_VALUE, required = true)
      @RequestParam(value = "level", required = true) String level);

  @ApiOperation(value = SwaggerBase.GET_LOG_LEVEL, notes = SwaggerBase.GET_LOG_LEVEL_NOTES)
  @RequestMapping(value = "/logs/level", method = RequestMethod.GET)
  public Base<String> getLogLevel();

  @ApiOperation(value = SwaggerBase.LEVELS, notes = SwaggerBase.LEVELS_NOTES)
  @RequestMapping(value = "/logs/levels", method = RequestMethod.GET)
  public Base<String> getLogLevels();

}
