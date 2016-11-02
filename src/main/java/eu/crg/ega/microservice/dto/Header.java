package eu.crg.ega.microservice.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.microservice.constant.CoreConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@ApiModel("Header")
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Header {

  @ApiModelProperty(value = "API version", required = true)
  @XmlElement(name = "api_version")
  private String apiVersion = "v1";

  @ApiModelProperty(value = "HTTP status code", required = true)
  @XmlElement(name = "code")
  private String code = "200";

  @ApiModelProperty(value = "service answering the call", required = true)
  @XmlElement(name = "service")
  private String service = "service";

  @ApiModelProperty(value = "error message for developer", required = false)
  @XmlElement(name = "developer_message")
  private String developerMessage = "";

  @ApiModelProperty(value = "error message for user", required = true)
  @XmlElement(name = "user_message")
  private String userMessage = "OK";

  @ApiModelProperty(value = "internal error code", required = false)
  @XmlElement(name = "error_code")
  private String errorCode = "1";

  @ApiModelProperty(value = "link to documentation", required = true)
  @XmlElement(name = "doc_link")
  private String docLink = "https://www.ega-archive.org/";

  @ApiModelProperty(value = "error stack trace", required = false)
  @XmlElement(name = "error_stack")
  private String errorStack = "";

  public Header() {
    this.service = CoreConstants.MICROSERVICE;
    this.apiVersion = CoreConstants.API_VERSION;
  }

}
