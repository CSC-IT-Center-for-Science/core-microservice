package eu.crg.ega.microservice.dto.web;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.crg.ega.microservice.dto.submitter.StudyData;
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
@XmlRootElement(name = "organisation_data")
@XmlSeeAlso(value = {StudyData.class})
public class OrganisationData {

  @XmlElement(name = "ega_stable_id")
  private String egaStableId;

  @XmlElement(name = "name")
  private String name;

  @XmlElement(name = "type")
  private String type = "type";

  @XmlElement(name = "acronym")
  private String acronym;

  @XmlElement(name = "url")
  private String url;

  @XmlElement(name = "study_list")
  private List<StudyData> studyList;

}
