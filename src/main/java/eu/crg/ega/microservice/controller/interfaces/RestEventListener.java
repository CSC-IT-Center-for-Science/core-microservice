package eu.crg.ega.microservice.controller.interfaces;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.microservice.dto.message.ServiceMessage;
import eu.crg.ega.swaggerconstants.common.SwaggerBase;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
// Can't use this because the BaseController class implements all the interfaces
// @RequestMapping("/events")
public interface RestEventListener {

  @ApiOperation(value = SwaggerBase.EVENTS, notes = SwaggerBase.EVENTS_NOTES)
  @RequestMapping(value = "/events", method = RequestMethod.POST)
  public Base<String> receive(
      @ApiParam(name = "message", value = SwaggerBase.EVENTS_EVENT, required = true)
      @RequestBody ServiceMessage message)
      throws JsonParseException, JsonMappingException, IOException;

}
