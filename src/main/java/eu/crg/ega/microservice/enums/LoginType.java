package eu.crg.ega.microservice.enums;

import eu.crg.ega.microservice.exception.NotFoundException;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user_type")
public enum LoginType {

  REQUESTER("requester"), SUBMITTER("submitter"), INTERNAL("internal");

  private String value;

  public static LoginType parse(String type) {

    LoginType loginType = null;

    if (StringUtils.equalsIgnoreCase(type, REQUESTER.value)) {
      loginType = REQUESTER;
    } else if (StringUtils.equalsIgnoreCase(type, SUBMITTER.value)) {
      loginType = SUBMITTER;
    } else if (StringUtils.equalsIgnoreCase(type, INTERNAL.value)) {
      loginType = INTERNAL;
    } else {
      throw new NotFoundException("Login type not valid", type);
    }

    return loginType;
  }

}
