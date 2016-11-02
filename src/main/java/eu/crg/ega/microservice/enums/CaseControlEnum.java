package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CaseControlEnum {

  CASE("0", "case"), CONTROL("1", "control"), BOTH("2", "both"), NA("3", "NA");

  private String id;

  private String value;

  public static CaseControlEnum parse(String value) {
    CaseControlEnum caseControl = null;

    if (StringUtils.equalsIgnoreCase(value, CASE.value)) {
      caseControl = CASE;
    } else if (StringUtils.equalsIgnoreCase(value, CONTROL.value)) {
      caseControl = CONTROL;
    } else if (StringUtils.equalsIgnoreCase(value, BOTH.value)) {
      caseControl = BOTH;
    } else if (StringUtils.equalsIgnoreCase(value, NA.value)) {
      caseControl = NA;
    } else {
      throw new TypeNotFoundException("Value for case/control field not valid", value);
    }

    return caseControl;
  }

  public static CaseControlEnum parseById(String id) {
    CaseControlEnum caseControl = null;

    if (StringUtils.equalsIgnoreCase(id, CASE.id)) {
      caseControl = CASE;
    } else if (StringUtils.equalsIgnoreCase(id, CONTROL.id)) {
      caseControl = CONTROL;
    } else if (StringUtils.equalsIgnoreCase(id, BOTH.id)) {
      caseControl = BOTH;
    } else if (StringUtils.equalsIgnoreCase(id, NA.id)) {
      caseControl = NA;
    } else {
      throw new TypeNotFoundException("Id for case/control field not valid", id);
    }

    return caseControl;
  }

}
