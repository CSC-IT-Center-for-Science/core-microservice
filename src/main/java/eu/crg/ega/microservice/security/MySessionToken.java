package eu.crg.ega.microservice.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MySessionToken {

  private String sessionToken;
  
}
