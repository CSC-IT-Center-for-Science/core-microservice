package eu.crg.ega.microservice.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

/**
 * Enumeration representing all different types of ID that can be requested.<br>
 * Default value is INTERNAL_EBI_ID. 
 *
 */
@Log4j
@Getter
@AllArgsConstructor
public enum IdTypes {
  INTERNAL_EBI_ID("INTERNAL_EBI_ID"), INTERNAL_CRG_ID("INTERNAL_CRG_ID"), EGA_ACCESSION_ID("EGA_STABLE_ID"), ALIAS(
      "ALIAS");

  private String value;

  public static IdTypes parse(String s) {
    IdTypes type = INTERNAL_EBI_ID; // Default type

    if (StringUtils.isBlank(s)) {
      type = INTERNAL_EBI_ID;
    } else if (StringUtils.equalsIgnoreCase(s, INTERNAL_EBI_ID.value)) {
      type = INTERNAL_EBI_ID;
    } else if (StringUtils.equalsIgnoreCase(s, INTERNAL_CRG_ID.value)) {
      type = INTERNAL_CRG_ID;
    } else if (StringUtils.equalsIgnoreCase(s, EGA_ACCESSION_ID.value)) {
      type = EGA_ACCESSION_ID;
    } else if (StringUtils.equalsIgnoreCase(s, ALIAS.value)) {
      type = ALIAS;
    } else {
      log.error("Id type not valid");
    }
    return type;
  }

}
