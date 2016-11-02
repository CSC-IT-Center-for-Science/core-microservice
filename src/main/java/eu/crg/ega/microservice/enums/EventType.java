package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.EventTypeException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventType {
  FTP("ftp"), RESPONSE("response"), FILE("file"), ASPERA("aspera"), WORKFLOW("workflow");

  private String type;

  public static EventType parseType(String typeStr) {
    EventType type = null;

    if (StringUtils.equalsIgnoreCase(typeStr, FTP.getType())) {
      type = FTP;
    } else if (StringUtils.equalsIgnoreCase(typeStr, RESPONSE.getType())) {
      type = RESPONSE;
    } else if (StringUtils.equalsIgnoreCase(typeStr, FILE.getType())) {
      type = FILE;
    } else if (StringUtils.equalsIgnoreCase(typeStr, ASPERA.getType())) {
      type = ASPERA;
    } else if (StringUtils.equalsIgnoreCase(typeStr, WORKFLOW.getType())) {
      type = WORKFLOW;
    } else {
      throw new EventTypeException("Event type not valid");
    }

    return type;
  }

}
