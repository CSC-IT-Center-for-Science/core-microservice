package eu.crg.ega.microservice.exception;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class TypeNotFoundException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = -3247069889499867687L;
  
  private String type;

  public TypeNotFoundException(String message) {
    super(message);
  }
  
  public TypeNotFoundException(String message, String type) {
    super(message);
    this.type = type;
  }

  public TypeNotFoundException(String message, Throwable t) {
    super(message, t);
  }

  @Override
  public String toString() {
    String s = getClass().getName();
    String message = getLocalizedMessage();
    if (StringUtils.isNotBlank(type)) {
      message += " (" + type + ")";
    }
    return (message != null) ? (s + ": " + message) : s;
  }
  
}
