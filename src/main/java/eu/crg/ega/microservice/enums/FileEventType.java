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
public enum FileEventType {

  UPDATE("update");

        private String value;

  public static FileEventType parse(String content) {
    FileEventType type = null;

    if (StringUtils.containsIgnoreCase(content, FileEventType.UPDATE.getValue())) {
      type = FileEventType.UPDATE;
    } else {
      log.error("File event type not valid!");
    }

    return type;
  }
}
