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
import eu.crg.ega.submissionxsdclasses.STUDYSET;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "studyDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "study_data")
@XmlSeeAlso(value = {CommonData.class, STUDYSET.class, AttributeData.class})
public class StudyData extends CommonData {
  
  @XmlElement(name = "xml_root_element")
  private STUDYSET xmlRootElement;

  @XmlElement(name = "study_type_id")
  private String studyTypeId;
  
  @XmlElement(name = "study_type")
  private String studyType;
  
  @XmlElement(name = "short_name")
  private String shortName;
  
  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "study_abstract")
  private String studyAbstract;
  
  @XmlElement(name = "own_term")
  private String ownTerm;
  
  @XmlElement(name = "pub_med_ids")
  private List<String> pubMedIds;
  
  @XmlElement(name = "custom_tags")
  private List<AttributeData> customTags;
  
}