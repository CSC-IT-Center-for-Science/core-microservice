package eu.crg.ega.microservice.dto.submitter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "attribute_data")
public class AttributeData {

  @XmlElement(name = "tag")
  private String tag;
  
  @XmlElement(name = "value")
  private String value;
  
  @XmlElement(name = "label")
  private String label;
  
  @XmlElement(name = "unit")
  private String unit;

  @XmlElement(name = "group")
  private String group;
  
}
