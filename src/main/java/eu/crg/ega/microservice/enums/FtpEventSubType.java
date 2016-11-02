package eu.crg.ega.microservice.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Getter
@ToString
public enum FtpEventSubType {
  LOGIN("logged in", FtpEventGroupType.LOGIN_TYPE),
  LOGOUT("logout",FtpEventGroupType.LOGIN_TYPE),
  AUTHENTICATION_FAILED("authentication failed", FtpEventGroupType.LOGIN_TYPE),
  STORE("[stor]", FtpEventGroupType.COMMAND_TYPE),
  DELETE("[dele]", FtpEventGroupType.COMMAND_TYPE),
  UPLOADED("uploaded", FtpEventGroupType.COMMAND_TYPE),
  DOWNLOAD("[retr]", FtpEventGroupType.COMMAND_TYPE);

  private String value;
  private FtpEventGroupType groupType;

  public static FtpEventSubType parse(String content) {
    FtpEventSubType type = null;

    if (StringUtils.containsIgnoreCase(content, FtpEventSubType.LOGIN.getValue())) {
      type = FtpEventSubType.LOGIN;
    } else if (StringUtils.containsIgnoreCase(content, FtpEventSubType.LOGOUT.getValue())) {
      type = FtpEventSubType.LOGOUT;
    } else if (StringUtils.containsIgnoreCase(content,
                                              FtpEventSubType.AUTHENTICATION_FAILED.getValue())) {
      type = FtpEventSubType.AUTHENTICATION_FAILED;
    } else if (StringUtils.containsIgnoreCase(content, FtpEventSubType.STORE.getValue())) {
      type = FtpEventSubType.STORE;
    } else if (StringUtils.containsIgnoreCase(content, FtpEventSubType.DELETE.getValue())) {
      type = FtpEventSubType.DELETE;
    } else if (StringUtils.containsIgnoreCase(content, FtpEventSubType.UPLOADED.getValue())) {
      type = FtpEventSubType.UPLOADED;
    } else if (StringUtils.containsIgnoreCase(content, FtpEventSubType.DOWNLOAD.getValue())) {
      type = FtpEventSubType.DOWNLOAD;
    } else {
      log.error("FTP event type not valid!");
    }

    return type;
  }

  /**
   * Returns all types that belong to that group.
   */
  public static List<FtpEventSubType> findByTypeGroup(FtpEventGroupType groupType) {
    List<FtpEventSubType> listSubtypes = new ArrayList<FtpEventSubType>();

    if (groupType == FtpEventGroupType.ALL) {
      listSubtypes = Arrays.asList(FtpEventSubType.values());

    } else {
      for (FtpEventSubType subtype : FtpEventSubType.values()) {
        if (subtype.getGroupType() == groupType) {
          listSubtypes.add(subtype);
        }
      }
    }

    return listSubtypes;
  }
}
