package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@AllArgsConstructor
public enum PetitionType {
  DATASET("DATASET"), STUDY("STUDY"), FILE("FILE");

  private String value;

  public static PetitionType parse(String s) {
    PetitionType type = FILE;

    if (StringUtils.isBlank(s)) {
      type = FILE;
    } else if (StringUtils.equalsIgnoreCase(s, FILE.value)) {
      type = FILE;
    } else if (StringUtils.equalsIgnoreCase(s, DATASET.value)) {
      type = DATASET;
    } else if (StringUtils.equalsIgnoreCase(s, STUDY.value)) {
      type = STUDY;
    } else {
      log.error("Element type not valid");
      throw new TypeNotFoundException("Element type passed could not be parsed");
    }
    return type;
  }

}
