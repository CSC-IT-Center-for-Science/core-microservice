package eu.crg.ega.microservice.enums;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@ApiModel("Request status")
@Log4j
@AllArgsConstructor
@Getter
public enum RequestStatus {
  DRAFT("draft"), SUBMITTED("submitted");

  @ApiModelProperty(value = "status of the request", required = true)
  private String status;

  public static RequestStatus parse(String value) {
    RequestStatus status = null;

    if (value.equals(DRAFT.status)) {
      status = DRAFT;
    } else if (value.equals(SUBMITTED.status)) {
      status = SUBMITTED;
    } else {
      log.error("Request status not valid");
    }

    return status;
  }
}
