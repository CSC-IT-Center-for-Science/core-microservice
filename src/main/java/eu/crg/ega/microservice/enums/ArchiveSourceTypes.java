package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@AllArgsConstructor
public enum ArchiveSourceTypes {
  CRG_INBOX("CRG_INBOX"), 
  CRG_OUTBOX("CRG_OUTBOX"), 
  CRG_STAGING("CRG_STAGING"), 
  CRG_ARCHIVE("CRG_ARCHIVE"),
  CRG_DOWNLOADBOX("CRG_DOWNLOADBOX"), 
  CRG_DOWNLOADBOX_STAGING("CRG_DOWNLOADBOX_STAGING"), 
  EBI_INBOX("EBI_INBOX"), 
  EBI_STAGING("EBI_STAGING"), 
  EBI_ARCHIVE("EBI_ARCHIVE");

  private String value;

  public static ArchiveSourceTypes parse(String s) {
    ArchiveSourceTypes type = CRG_ARCHIVE;

    if (StringUtils.isBlank(s)) {
      type = CRG_ARCHIVE;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_INBOX.value)) {
      type = CRG_INBOX;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_OUTBOX.value)) {
      type = CRG_OUTBOX;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_STAGING.value)) {
      type = CRG_STAGING;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_ARCHIVE.value)) {
      type = CRG_ARCHIVE;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_DOWNLOADBOX.value)) {
      type = CRG_DOWNLOADBOX;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_DOWNLOADBOX_STAGING.value)) {
      type = CRG_DOWNLOADBOX_STAGING;
    } else if (StringUtils.equalsIgnoreCase(s, EBI_INBOX.value)) {
      type = EBI_INBOX;
    } else if (StringUtils.equalsIgnoreCase(s, EBI_STAGING.value)) {
      type = EBI_STAGING;
    } else if (StringUtils.equalsIgnoreCase(s, EBI_ARCHIVE.value)) {
      type = EBI_ARCHIVE;
    } else {
      log.error("Source type not valid");
      throw new TypeNotFoundException("Source type passed could not be parsed");
    }
    return type;
  }

}
