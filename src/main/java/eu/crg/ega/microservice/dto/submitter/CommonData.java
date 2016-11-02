package eu.crg.ega.microservice.dto.submitter;

import java.lang.reflect.Field;
import java.util.ArrayList;
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

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import eu.crg.ega.microservice.enums.EntityStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "common_data")
@XmlSeeAlso(value = {EntityStatus.class})
public class CommonData {

  @XmlElement(name = "id")
  private String id;

  @XmlElement(name = "ebi_id")
  private String ebiId;

  @XmlElement(name = "submission_id")
  private String submissionId;

  @XmlElement(name = "era_submission_id")
  private String eraSubmissionId;
  
  @XmlElement(name = "user_id")
  private String userId;

  @XmlElement(name = "submitter_id")
  private String submitterId;

  @XmlElement(name = "status")
  private EntityStatus status;

  @XmlElement(name = "version")
  private Integer version = 1;

  @XmlElement(name = "creation_time")
  private DateTime creationTime;

  @XmlElement(name = "edition_time")
  private DateTime editionTime;

  @XmlElement(name = "first_public")
  private DateTime firstPublic;

  @XmlElement(name = "submission_command_ids")
  private List<String> submissionCommandIds;
  
  /*
   * Validation fields
   */
  @XmlElement(name = "validation_error_messages")
  private Set<String> validationErrorMessages;

  @XmlElement(name = "submission_info_messages")
  private List<String> submissionInfoMessages;

  @XmlElement(name = "submission_error_messages")
  private List<String> submissionErrorMessages;

  @XmlElement(name = "validation_result")
  private boolean validationResult;

  @XmlElement(name = "ebi_submission_details_ids")
  private List<String> ebiSubmissionDetailsIds;

  @XmlElement(name = "xml")
  private String xml;
  
  @XmlElement(name = "json")
  private String json;

  @XmlElement(name = "alias")
  private String alias;
  
  @XmlElement(name = "ega_accession_id")
  private String egaAccessionId;
  
  @XmlElement(name = "center_name")
  private String centerName;

  public void addSubmissionActionId(String id) {
    if (submissionCommandIds == null) {
      submissionCommandIds = new ArrayList<String>();
    }
    submissionCommandIds.add(id);
  }

  public void addEbiSubmissionDetailsId(String id) {
    if (ebiSubmissionDetailsIds == null) {
      ebiSubmissionDetailsIds = new ArrayList<String>();
    }
    ebiSubmissionDetailsIds.add(id);
  }
  
  public static String[] retrieveCommonPropertiesNames() {
    List<String> list = new ArrayList<String>();
    for (Field f : CommonData.class.getDeclaredFields()) {
      list.add(f.getName());
    }
    return list.toArray(new String[list.size()]);
  }
  
  public boolean existsAtEbi() {
    return StringUtils.isNotBlank(ebiId) && StringUtils.equals(id, ebiId);
  }
  
}
