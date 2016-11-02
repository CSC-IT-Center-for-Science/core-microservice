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
public class Run {

  private String runId;
  private DateTime auditTime;
  private String centerName;
  private String egaId;
  private String egaSubmissionAccountId;
  private DateTime firstCreated;
  private DateTime firstPublic;
  private DateTime holdDate;
  private String instrumentModel;
  private String instrumentPlatform;
  private DateTime lastUpdated;
  private String md5;
  private String protect;
  private String runAlias;
  private String runCenterName;
  private String runXml;
  private Integer statusId;
  private String submissionAccountId;
  private String submissionId;
  private Integer version;
}
