package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.TypeNotFoundException;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LibraryLayoutEnum {

  PAIRED("0", "PAIRED"), SINGLE("1", "SINGLE");

  private String id;

  private String value;

  public static LibraryLayoutEnum parse(String value) {
    LibraryLayoutEnum layout = null;
    
    if (StringUtils.equalsIgnoreCase(value, PAIRED.value)) {
      layout = PAIRED;
    } else if (StringUtils.equalsIgnoreCase(value, SINGLE.value)) {
      layout = SINGLE;
    } else {
      throw new TypeNotFoundException("Value for library layout field not valid", value);
    }
    
    return layout;
  }
  
  public static LibraryLayoutEnum parseById(String id) {
    LibraryLayoutEnum layout = null;

    if (StringUtils.equalsIgnoreCase(id, PAIRED.id)) {
      layout = PAIRED;
    } else if (StringUtils.equalsIgnoreCase(id, SINGLE.id)) {
      layout = SINGLE;
    } else {
      throw new TypeNotFoundException("Id for library layout field not valid", id);
    }

    return layout;
  }

}
