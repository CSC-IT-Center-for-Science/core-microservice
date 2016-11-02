package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.PreConditionFailed;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityStatus {

  DRAFT("DRAFT"),
  VALIDATED("VALIDATED"),
  VALIDATED_WITH_ERRORS("VALIDATED_WITH_ERRORS"),
  SUBMITTED("SUBMITTED"),
  PARTIALLY_SUBMITTED("PARTIALLY_SUBMITTED"),
  SUBMITTED_DRAFT("SUBMITTED_DRAFT"),
  SUBMITTED_VALIDATED("SUBMITTED_VALIDATED"),
  SUBMITTED_VALIDATED_WITH_ERRORS("SUBMITTED_VALIDATED_WITH_ERRORS")
  /*
   * RELEASED, RELEASED_WITH_ERRORS, DEPRECATED, DELETED
   */;

  private String status;

  public static EntityStatus parse(String status) {
    EntityStatus parsedStatus = null;

    if (StringUtils.equalsIgnoreCase(status, DRAFT.status)) {
      parsedStatus = DRAFT;
    } else if (StringUtils.equalsIgnoreCase(status, VALIDATED.status)) {
      parsedStatus = VALIDATED;
    } else if (StringUtils.equalsIgnoreCase(status, VALIDATED_WITH_ERRORS.status)) {
      parsedStatus = VALIDATED_WITH_ERRORS;
    } else if (StringUtils.equalsIgnoreCase(status, SUBMITTED.status)) {
      parsedStatus = SUBMITTED;
    } else if (StringUtils.equalsIgnoreCase(status, PARTIALLY_SUBMITTED.status)) {
      parsedStatus = PARTIALLY_SUBMITTED;
    } else if (StringUtils.equalsIgnoreCase(status, SUBMITTED_DRAFT.status)) {
      parsedStatus = SUBMITTED_DRAFT;
    } else if (StringUtils.equalsIgnoreCase(status, SUBMITTED_VALIDATED.status)) {
      parsedStatus = SUBMITTED_VALIDATED;
    } else if (StringUtils.equalsIgnoreCase(status, SUBMITTED_VALIDATED_WITH_ERRORS.status)) {
      parsedStatus = SUBMITTED_VALIDATED_WITH_ERRORS;
    } else {
      throw new PreConditionFailed("Status not valid: " + status);
    }
    return parsedStatus;
  }
  
  public boolean isSubmitted() {
    boolean isSubmitted = false;
    if (this == SUBMITTED || this == SUBMITTED_DRAFT || this == SUBMITTED_VALIDATED
        || this == SUBMITTED_VALIDATED_WITH_ERRORS || this == PARTIALLY_SUBMITTED) {
      isSubmitted = true;
    }
    return isSubmitted;
  }
  
  public boolean isValidated() {
    boolean isValidated = false;
    if(this == VALIDATED || this == SUBMITTED_VALIDATED) {
      isValidated = true;
    }
    return isValidated;
  }
  
}
