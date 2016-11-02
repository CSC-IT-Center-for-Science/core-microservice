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
public enum WorkflowType {
  //Commands
  NEW_DOWNLOADBOX("new_downloadbox"),
  START("start"),
  REENCRYPT("reencrypt"),
  POPULATE_ARCHIVE("populate_archive"),

  //Events
  NEW_DOWNLOADBOX_FAIL("new_downloadbox_fail"),
  START_OK("start_ok"),
  START_FAIL("start_fail"),
  USER_INFORMATION_OK("user_information_ok"),
  USER_INFORMATION_FAIL("user_information_fail"),
  FILES_DATA_OK("files_data_ok"),
  FILES_DATA_FAIL("files_data_fail"),
  PERMISSIONS_CHECKED_OK("permissions_checked_ok"),
  PERMISSIONS_CHECKED_FAIL("permissions_checked_fail"),
  HOME_SETUP_OK("home_setup_ok"),
  HOME_SETUP_FAIL("home_setup_fail"),
  HOME_MD5FILE_OK("home_md5file_ok"),
  HOME_MD5FILE_FAIL("home_md5file_fail"),
  ARCHIVE_INFO_POPULATED_OK("archive_info_populated_ok"),
  ARCHIVE_INFO_POPULATED_FAIL("archive_info_populated_fail"),
  ARCHIVE_REENCRYPT_START_FAIL("archive_reencrypt_start_fail"),
  ARCHIVE_REENCRYPT_FAIL_FAIL("archive_reencrypt_fail_fail"),
  REENCRYPT_STARTED("reencrypt_started"),
  REENCRYPT_OK("reencrypt_ok"),
  REENCRYPT_FAIL("reencrypt_fail"),
  MOVING_STARTED("moving_started"),
  MOVING_OK("moving_ok"),
  MOVING_FAIL("moving_fail"),
  WORKFLOW_ERROR("workflow_error"),
  DOWNLOADBOX_ERROR("downloadbox_error"),
  WORKER_ERROR("worker_error"),
  ARCHIVE_ERROR("archive_error"),
  ALL_FILES_DONE("all_files_done"),
  ALL_FILES_DONE_FAIL("all_files_done_fail"),
  HOME_SETUP_PERMISSIONS_OK("home_setup_permissions_ok"),
  HOME_SETUP_PERMISSIONS_FAIL("home_setup_permissions_fail"),
  DONE_DOWNLOADBOX("done_downloadbox");

  private String value;

  public static WorkflowType parse(String s) {
    WorkflowType type = null;

    if (StringUtils.equalsIgnoreCase(s, NEW_DOWNLOADBOX.value)) {
      type = NEW_DOWNLOADBOX;
    } else if (StringUtils.equalsIgnoreCase(s, NEW_DOWNLOADBOX_FAIL.value)) {
      type = NEW_DOWNLOADBOX_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, START.value)) {
      type = START;
    } else if (StringUtils.equalsIgnoreCase(s, START_OK.value)) {
      type = START_OK;
    } else if (StringUtils.equalsIgnoreCase(s, START_FAIL.value)) {
      type = START_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, USER_INFORMATION_OK.value)) {
      type = USER_INFORMATION_OK;
    } else if (StringUtils.equalsIgnoreCase(s, USER_INFORMATION_FAIL.value)) {
      type = USER_INFORMATION_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, FILES_DATA_OK.value)) {
      type = FILES_DATA_OK;
    } else if (StringUtils.equalsIgnoreCase(s, FILES_DATA_FAIL.value)) {
      type = FILES_DATA_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, PERMISSIONS_CHECKED_OK.value)) {
      type = PERMISSIONS_CHECKED_OK;
    } else if (StringUtils.equalsIgnoreCase(s, PERMISSIONS_CHECKED_FAIL.value)) {
      type = PERMISSIONS_CHECKED_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, HOME_SETUP_OK.value)) {
      type = HOME_SETUP_OK;
    } else if (StringUtils.equalsIgnoreCase(s, HOME_SETUP_FAIL.value)) {
      type = HOME_SETUP_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, ARCHIVE_INFO_POPULATED_OK.value)) {
      type = ARCHIVE_INFO_POPULATED_OK;
    } else if (StringUtils.equalsIgnoreCase(s, ARCHIVE_INFO_POPULATED_FAIL.value)) {
      type = ARCHIVE_INFO_POPULATED_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, ARCHIVE_REENCRYPT_START_FAIL.value)) {
      type = ARCHIVE_REENCRYPT_START_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, MOVING_STARTED.value)) {
      type = MOVING_STARTED;
    } else if (StringUtils.equalsIgnoreCase(s, MOVING_OK.value)) {
      type = MOVING_OK;
    } else if (StringUtils.equalsIgnoreCase(s, MOVING_FAIL.value)) {
      type = MOVING_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, DONE_DOWNLOADBOX.value)) {
      type = DONE_DOWNLOADBOX;
    } else if (StringUtils.equalsIgnoreCase(s, WORKFLOW_ERROR.value)) {
      type = WORKFLOW_ERROR;
    } else if (StringUtils.equalsIgnoreCase(s, DOWNLOADBOX_ERROR.value)) {
      type = DOWNLOADBOX_ERROR;
    } else if (StringUtils.equalsIgnoreCase(s, WORKER_ERROR.value)) {
      type = WORKER_ERROR;
    } else if (StringUtils.equalsIgnoreCase(s, ARCHIVE_ERROR.value)) {
      type = ARCHIVE_ERROR;
    } else if (StringUtils.equalsIgnoreCase(s, ALL_FILES_DONE.value)) {
      type = ALL_FILES_DONE;
    } else if (StringUtils.equalsIgnoreCase(s, HOME_SETUP_PERMISSIONS_OK.value)) {
      type = HOME_SETUP_PERMISSIONS_OK;
    } else if (StringUtils.equalsIgnoreCase(s, HOME_SETUP_PERMISSIONS_FAIL.value)) {
      type = HOME_SETUP_PERMISSIONS_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, REENCRYPT.value)) {
      type = REENCRYPT;
    } else if (StringUtils.equalsIgnoreCase(s, REENCRYPT_STARTED.value)) {
      type = REENCRYPT_STARTED;
    } else if (StringUtils.equalsIgnoreCase(s, REENCRYPT_OK.value)) {
      type = REENCRYPT_OK;
    } else if (StringUtils.equalsIgnoreCase(s, REENCRYPT_FAIL.value)) {
      type = REENCRYPT_FAIL;
    } else if (StringUtils.equalsIgnoreCase(s, POPULATE_ARCHIVE.value)) {
      type = POPULATE_ARCHIVE;
    } else {
      log.error("Id type not valid");
    }
    return type;
  }
}
