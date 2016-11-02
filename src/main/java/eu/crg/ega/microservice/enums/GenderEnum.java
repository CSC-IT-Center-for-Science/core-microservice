package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {

  FEMALE("0", "female"), MALE("1", "male"), UNKNOWN("2", "unknown");

  private String id;

  private String value;

  public static GenderEnum parse(String value) {
    GenderEnum gender = null;

    if (StringUtils.equalsIgnoreCase(value, FEMALE.value)) {
      gender = FEMALE;
    } else if (StringUtils.equalsIgnoreCase(value, MALE.value)) {
      gender = MALE;
    } else if (StringUtils.equalsIgnoreCase(value, UNKNOWN.value)) {
      gender = UNKNOWN;
    } else {
      throw new TypeNotFoundException("Value for gender field not valid", value);
    }

    return gender;
  }
  
  public static GenderEnum parseById(String id) {
    GenderEnum gender = null;

    if (StringUtils.equalsIgnoreCase(id, FEMALE.id)) {
      gender = FEMALE;
    } else if (StringUtils.equalsIgnoreCase(id, MALE.id)) {
      gender = MALE;
    } else if (StringUtils.equalsIgnoreCase(id, UNKNOWN.id)) {
      gender = UNKNOWN;
    } else {
      throw new TypeNotFoundException("Id for gender field not valid", id);
    }

    return gender;
  }

}
