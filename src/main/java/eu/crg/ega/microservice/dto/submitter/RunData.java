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
import eu.crg.ega.submissionxsdclasses.RUNSET;

@Getter
@Setter
@Builder(builderMethodName = "runDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "run_data")
@XmlSeeAlso(value = {CommonData.class, RUNSET.class, FileData.class})
public class RunData extends CommonData {

  @XmlElement(name = "xml_root_element")
  private RUNSET xmlRootElement;

  @XmlElement(name = "sample_alias")
  private String sampleAlias;
  
  @XmlElement(name = "sample_id")
  private String sampleId;
  
  @XmlElement(name = "run_file_type_id")
  private String runFileTypeId;
  
  @XmlElement(name = "run_file_type")
  private String runFileType;
  
  @XmlElement(name = "experiment_id")
  private String experimentId;
  
  @XmlElement(name = "generated_experiment_id")
  private String generatedExperimentId;
  
  @XmlElement(name = "files")
  private List<FileData> files;

}
