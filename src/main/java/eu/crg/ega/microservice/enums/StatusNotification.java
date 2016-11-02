package eu.crg.ega.microservice.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Getter
public enum StatusNotification {

  PENDING("pending"), VIEWED("viewed");

  private String status;

  public static StatusNotification parse(String newStatus) {
    StatusNotification statusNotification = null;

    if (StringUtils.equalsIgnoreCase(newStatus, StatusNotification.PENDING.status)) {
      statusNotification = StatusNotification.PENDING;
    } else if (StringUtils.equalsIgnoreCase(newStatus, StatusNotification.VIEWED.status)) {
      statusNotification = StatusNotification.VIEWED;
    } else {
      log.error("Status not valid!");
    }

    return statusNotification;
  }
}
