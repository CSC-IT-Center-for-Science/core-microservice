package eu.crg.ega.microservice.controller.interfaces;

import com.wordnik.swagger.annotations.ApiOperation;

import eu.crg.ega.microservice.dto.Base;
import eu.crg.ega.swaggerconstants.common.SwaggerBase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Can't use this because the BaseController class implements all the interfaces
// @RequestMapping("/metrics/ega/")
public interface Metrics {

  @ApiOperation(value = SwaggerBase.RESET, notes = SwaggerBase.RESET_NOTES)
  @RequestMapping(value = "/metrics/ega/reset", method = RequestMethod.PUT)
  public Base<String> reset();

}
