package eu.crg.ega.microservice.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Getter
@ToString
public enum AsperaEventType {
  LOGIN("login"), LOGOUT("logout"), DOWNLOADING("downloading"), DOWNLOADED("downloaded"), UPLOADING("uploading"), UPLOADED("uploaded"), ERROR("error");

  private String value;

  public static AsperaEventType parse(String s) {
    AsperaEventType type = null;

    if (StringUtils.equalsIgnoreCase(s, LOGIN.value)) {
      type = LOGIN;
    } else if (StringUtils.equalsIgnoreCase(s, LOGOUT.value)) {
      type = LOGOUT;
    } else if (StringUtils.equalsIgnoreCase(s, DOWNLOADING.value)) {
      type = DOWNLOADING;
    } else if (StringUtils.equalsIgnoreCase(s, DOWNLOADED.value)) {
      type = DOWNLOADED;
    } else if (StringUtils.equalsIgnoreCase(s, UPLOADING.value)) {
      type = UPLOADING;
    } else if (StringUtils.equalsIgnoreCase(s, UPLOADED.value)) {
      type = UPLOADED;
    } else if (StringUtils.equalsIgnoreCase(s, ERROR.value)) {
      type = ERROR;
    } else {
      log.error("Id type not valid");
    }
    return type;
  }

}