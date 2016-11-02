package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@AllArgsConstructor
public enum ArchiveIdTypes {
  EBI_INTERNAL_ID("EBI_INTERNAL_ID"),
  CRG_INTERNAL_ID("CRG_INTERNAL_ID"),
  FULLPATH("FULLPATH"),
  RELATIVE_PATH("RELATIVE_PATH"),
  FILENAME("FILENAME"),
  EGA_ACCESSION_ID("EGA_ACCESSION_ID"),
  EBI_ACCESSION_ID("EBI_ACCESSION_ID"),
  CRG_ACCESSION_ID("CRG_ACCESSION_ID"),
  MD5_UNENC("MD5_UNENC"),
  OBJECT_ID("OBJECT_ID");

  private String value;

  public static ArchiveIdTypes parse(String s) {
    ArchiveIdTypes type = null;

    if (StringUtils.isBlank(s)) {
      type = OBJECT_ID;
    } else if (StringUtils.equalsIgnoreCase(s, EBI_INTERNAL_ID.value)) {
      type = EBI_INTERNAL_ID;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_INTERNAL_ID.value)) {
      type = CRG_INTERNAL_ID;
    } else if (StringUtils.equalsIgnoreCase(s, EBI_ACCESSION_ID.value)) {
      type = EBI_ACCESSION_ID;
    } else if (StringUtils.equalsIgnoreCase(s, EGA_ACCESSION_ID.value)) {
      type = EBI_ACCESSION_ID;
    } else if (StringUtils.equalsIgnoreCase(s, FULLPATH.value)) {
      type = FULLPATH;
    } else if (StringUtils.equalsIgnoreCase(s, RELATIVE_PATH.value)) {
      type = RELATIVE_PATH;
    } else if (StringUtils.equalsIgnoreCase(s, FILENAME.value)) {
      type = FILENAME;
    } else if (StringUtils.equalsIgnoreCase(s, CRG_ACCESSION_ID.value)) {
      type = CRG_ACCESSION_ID;
    } else if (StringUtils.equalsIgnoreCase(s, MD5_UNENC.value)) {
      type = MD5_UNENC;
    } else if (StringUtils.equalsIgnoreCase(s, OBJECT_ID.value)) {
      type = OBJECT_ID;
    } else {
      log.error("Id type not valid");
      throw new TypeNotFoundException("Id type passed could not be parsed");
    }
    return type;
  }
  
}
