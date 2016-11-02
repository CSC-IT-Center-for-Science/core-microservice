package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.NotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DatasetAccessType {

  PUBLIC("PUBLIC"), REGISTERED("REGISTERED"), CONTROLLED("CONTROLLED");

  private String type;

  public static DatasetAccessType parse(String value) {
    DatasetAccessType accessType = null;
    if (StringUtils.equalsIgnoreCase(value, PUBLIC.type)) {
      accessType = PUBLIC;
    } else if (StringUtils.equalsIgnoreCase(value, REGISTERED.type)) {
      accessType = REGISTERED;
    } else if (StringUtils.equalsIgnoreCase(value, CONTROLLED.type)) {
      accessType = CONTROLLED;
    } else {
      throw new NotFoundException("Type not found");
    }
    return accessType;
  }
  
}
