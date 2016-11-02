package eu.crg.ega.microservice.dto.submitter;


import java.util.List;
import java.util.Set;

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

import org.joda.time.DateTime;

import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.microservice.enums.SubmissionStatus;
import eu.crg.ega.swaggerconstants.submitter.SwaggerSubmission;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "submission_data")
@XmlSeeAlso(value = {SubmissionStatus.class})
public class SubmissionData {
  
  @ApiModelProperty(value = "id", required = false)
  @XmlElement(name = "id")
  private String id;
  
  @ApiModelProperty(value = "ebiId", required = false)
  @XmlElement(name = "ebi_id")
  private String ebiId;
  
  @ApiModelProperty(value = "description", required = false)
  @XmlElement(name = "user_id")
  private String userId;
  
  @ApiModelProperty(value = "submitterId", required = false)
  @XmlElement(name = "submitter_id")
  private String submitterId;
  
  @ApiModelProperty(value = "status", required = false)
  @XmlElement(name = "status")
  private SubmissionStatus status;
  
  @ApiModelProperty(value = "version", required = false)
  @XmlElement(name = "version")
  private Integer version = 1;
  
  @ApiModelProperty(value = "description", required = false)
  @XmlElement(name = "creation_time")
  private DateTime creationTime;
  
  @ApiModelProperty(value = "editionTime", required = false)
  @XmlElement(name = "edition_time")
  private DateTime editionTime;
  
  /*
   * Validation fields
   */
  @ApiModelProperty(value = "validationInfo", required = false)
  @XmlElement(name = "validation_info")
  private List<String> validationInfo;
  
  @ApiModelProperty(value = "validationError", required = false)
  @XmlElement(name = "validation_error")
  private Set<String> validationError;
  
  @ApiModelProperty(value = "ebiSubmissionDetailsIds", required = false)
  @XmlElement(name = "ebi_submission_details_ids")
  private List<String> ebiSubmissionDetailsIds;
  
  @ApiModelProperty(value = "validationResult", required = false)
  @XmlElement(name = "validation_result")
  private boolean validationResult;
  
  /*
   * Submission
   */
  @ApiModelProperty(value = "alias", required = false)
  @XmlElement(name = "alias")
  private String alias;
  
  @ApiModelProperty(value = "egaAccessionIds", required = false)
  @XmlElement(name = "ega_accession_ids")
  private Set<String> egaAccessionIds;
  
  @ApiModelProperty(value = "egaAccessionId", required = false)
  @XmlElement(name = "ega_accession_id")
  private String egaAccessionId;
  
  @ApiModelProperty(value = "title", required = true)
  @XmlElement(name = "title")
  private String title;
  
  @ApiModelProperty(value = "description", required = false)
  @XmlElement(name = "description")
  private String description;
  
  @ApiModelProperty(value = "analysisIds", required = false)
  @XmlElement(name = "analysis_ids")
  private List<String> analysisIds;
  
  @ApiModelProperty(value = "dacIds", required = false)
  @XmlElement(name = "dac_ids")
  private List<String> dacIds;
  
  @ApiModelProperty(value = "datasetIds", required = false)
  @XmlElement(name = "dataset_ids")
  private List<String> datasetIds;
  
  @ApiModelProperty(value = "experimentIds", required = false)
  @XmlElement(name = "experiment_ids")
  private List<String> experimentIds;
  
  @ApiModelProperty(value = "policyIds", required = false)
  @XmlElement(name = "policy_ids")
  private List<String> policyIds;
  
  @ApiModelProperty(value = "sampleIds", required = false)
  @XmlElement(name = "sample_ids")
  private List<String> sampleIds;
  
  @ApiModelProperty(value = "studyIds", required = false)
  @XmlElement(name = "study_ids")
  private List<String> studyIds;
  
  @ApiModelProperty(value = "runIds", required = false)
  @XmlElement(name = "run_ids")
  private List<String> runIds;

  @ApiModelProperty(value = "centerName", required = false)
  @XmlElement(name = "center_name")
  private String centerName;
  
  @ApiModelProperty(value = "xml", required = false)
  @XmlElement(name = "xml")
  private String xml;
  
  @XmlElement(name = "json")
  private String json;
  
  @XmlElement(name = "submission_project_id")
  private String submissionProjectId;
  
  /*
   * Submission to EBI
   */
  @ApiModelProperty(value = "submissionSubset", notes = SwaggerSubmission.EDIT_SUBSET_DATA, required = false)
  @XmlElement(name = "submission_subset")
  private SubmissionSubsetData submissionSubset;

}
