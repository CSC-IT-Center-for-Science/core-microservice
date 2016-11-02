package eu.crg.ega.microservice.dto.erapro;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

  private String submissionId;
  private DateTime auditTime;
  private String centerName;
  private String egaId;
  private String egaSubmissionAccountId;
  private DateTime firstCreated;
  private DateTime lastUpdated;
  private String md5;
  private String protect;
  private String submissionAccountId;
  private String submissionAlias;
  private DateTime submissionDate;
  private String submissionTool;
  private String submissionXml;
  private Integer version;
}
