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
public class Experiment {

  private String experimentId;
  private DateTime auditTime;
  private String centerName;
  private String egaId;
  private String egaSubmissionAccountId;
  private String experimentAlias;
  private String experimentXml;
  private DateTime firstCreated;
  private DateTime firstPublic;
  private DateTime holdDate;
  private String instrumentModel;
  private String instrumentPlatform;
  private DateTime lastUpdated;
  private String libraryLayout;
  private String libraryName;
  private String librarySelection;
  private String librarySource;
  private String libraryStrategy;
  private String md5;
  private Long pairedNominalLength;
  private Long pairedNominalSdev;
  private String protect;
  private Integer statusId;
  private String studyId;
  private String submissionAccountId;
  private String submissionId;
  private Integer version;

}