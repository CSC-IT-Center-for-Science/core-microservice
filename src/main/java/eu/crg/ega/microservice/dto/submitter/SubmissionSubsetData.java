package eu.crg.ega.microservice.dto.submitter;

import java.util.ArrayList;
import java.util.List;

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
@XmlRootElement(name = "submission_subset_data")
public class SubmissionSubsetData {
  
  @XmlElement(name = "analysis_ids")
  private List<String> analysisIds = new ArrayList<String>();
  
  @XmlElement(name = "dac_ids")
  private List<String> dacIds = new ArrayList<String>();
  
  @XmlElement(name = "dataset_ids")
  private List<String> datasetIds = new ArrayList<String>();
  
  @XmlElement(name = "experiment_ids")
  private List<String> experimentIds = new ArrayList<String>();
  
  @XmlElement(name = "policy_ids")
  private List<String> policyIds = new ArrayList<String>();

  @XmlElement(name = "run_ids")
  private List<String> runIds = new ArrayList<String>();
  
  @XmlElement(name = "sample_ids")
  private List<String> sampleIds = new ArrayList<String>();
  
  @XmlElement(name = "study_ids")
  private List<String> studyIds = new ArrayList<String>();

}
