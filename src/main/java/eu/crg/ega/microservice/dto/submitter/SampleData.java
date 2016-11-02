package eu.crg.ega.microservice.dto.submitter;

import java.util.List;

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
import eu.crg.ega.submissionxsdclasses.SAMPLESET;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "sampleDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sample_data")
@XmlSeeAlso(value = {CommonData.class, SAMPLESET.class, AttributeData.class})
public class SampleData extends CommonData {

  @XmlElement(name = "xml_root_element")
  private SAMPLESET xmlRootElement;

  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "description")
  private String description;
  
  @XmlElement(name = "case_or_control_id")
  private String caseOrControlId;
  
  @XmlElement(name = "case_or_control")
  private String caseOrControl;
  
  @XmlElement(name = "gender_id")
  private String genderId;
  
  @XmlElement(name = "gender")
  private String gender;
  
  @XmlElement(name = "organism_part")
  private String organismPart;
  
  @XmlElement(name = "cell_line")
  private String cellLine;
  
  @XmlElement(name = "region")
  private String region;
  
  @XmlElement(name = "phenotype")
  private String phenotype;
  
  @XmlElement(name = "subject_id")
  private String subjectId;

  @XmlElement(name = "anonymized_name")
  private String anonymizedName;

  @XmlElement(name = "bio_sample_id")
  private String bioSampleId;

  @XmlElement(name="sample_age")
  private String sampleAge;

  @XmlElement(name="sample_detail")
  private String sampleDetail;
  
  @XmlElement(name = "attributes")
  private List<AttributeData> attributes;
  
}
