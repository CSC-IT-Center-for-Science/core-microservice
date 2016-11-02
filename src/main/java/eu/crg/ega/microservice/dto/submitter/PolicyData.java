package eu.crg.ega.microservice.dto.submitter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import eu.crg.ega.submissionxsdclasses.POLICYSET;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "policyDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "policy_data")
@XmlSeeAlso(value = {CommonData.class, POLICYSET.class})
public class PolicyData extends CommonData {
  
  @XmlElement(name = "xml_root_element")
  private POLICYSET xmlRootElement;

  @XmlElement(name = "dac_id")
  private String dacId;
  
  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "policy_text")
  private String policyText;
  
  @XmlElement(name = "url")
  private String url;
  
}
