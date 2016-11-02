package eu.crg.ega.microservice.dto.submitter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "contact_data")
public class ContactData {

  @XmlElement(name = "name")
  private String contactName; 
  
  @XmlElement(name = "email")
  private String email; 
  
  @XmlElement(name = "organisation")
  private String organisation; 
  
  @XmlElement(name = "phone_number")
  private String phoneNumber;
  
}
