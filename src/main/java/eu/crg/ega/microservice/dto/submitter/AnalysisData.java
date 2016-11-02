package eu.crg.ega.microservice.dto.submitter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import eu.crg.ega.submissionxsdclasses.ANALYSISSET;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "analysisDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "analysis_data")
@XmlSeeAlso(value = {ANALYSISSET.class, AttributeData.class, FileData.class})
public class AnalysisData extends CommonData {

  @XmlElement(name = "xml_root_element")
  private ANALYSISSET xmlRootElement;

  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "description")
  private String description;
  
  @XmlElement(name = "study_id")
  private String studyId;
  
  @XmlElement(name = "sample_references")
  private List<AttributeData> sampleReferences;

  @XmlElement(name = "analysis_center")
  private String analysisCenter; //optional
  
  @XmlElement(name = "analysis_date")
  private DateTime analysisDate; //optional
  
  @XmlElement(name = "analysis_type_id")
  private String analysisTypeId;  
  
  @XmlElement(name = "analysis_type")
  private String analysisType;
  
  @XmlElement(name = "analysis_file_type")
  private String analysisFileType;
  
  @XmlElement(name = "files")
  private List<FileData> files;
  
  @XmlElement(name = "attributes")
  private List<AttributeData> attributes;

  // BAM & VCF
  @XmlElement(name = "genome_id")
  private String genomeId;
  
  @XmlElement(name = "genome")
  private String genome;
  
  @XmlElement(name = "chromosome_references")
  private List<AttributeData> chromosomeReferences;
  
  @XmlElement(name = "chromosome_values")
  private List<AttributeData> chromosomeValues;
  
  // VCF only
  @XmlElement(name = "experiment_type_id")
  private List<String> experimentTypeId;
  
  @XmlElement(name = "experiment_type")
  private List<String> experimentType;
  
  @XmlElement(name = "platform")
  private String platform;
  
}
