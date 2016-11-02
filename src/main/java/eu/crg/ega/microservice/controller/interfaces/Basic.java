package eu.crg.ega.microservice.controller.interfaces;

import eu.crg.ega.microservice.dto.Base;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface Basic {

  @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
  public Base<String> hello(@PathVariable(value = "message") String message);
}
