package eu.crg.ega.microservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Getter
@ToString
public enum FtpEventGroupType {
  ALL(0), LOGIN_TYPE(1), COMMAND_TYPE(2);

  private Integer value;

  public static FtpEventGroupType parse(Integer typeStr) {
    FtpEventGroupType type = null;

    switch (typeStr) {
      case 0:
        type = ALL;
        break;
      case 1:
        type = LOGIN_TYPE;
        break;
      case 2:
        type = COMMAND_TYPE;
        break;
      default:
        log.error("Notification type grouping not valid!");
    }

    return type;
  }

}
