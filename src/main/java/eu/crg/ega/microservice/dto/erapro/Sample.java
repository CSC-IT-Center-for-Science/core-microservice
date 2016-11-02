package eu.crg.ega.microservice.dto.erapro;


import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Sample {

  private String sampleId;
  private String anonymizedName;
  private DateTime auditTime;
  private String auditUser;
  private String biosampleAuthority;
  private String biosampleId;
  private String centerName;
  private String checklistId;
  private String commonName;
  private String editable;
  private String egaDatasetId;
  private String egaId;
  private String egaSubmissionAccountId;
  private DateTime firstCreated;
  private DateTime firstPublic;
  private String fixed;
  private String fixedCommonName;
  private String fixedScientificName;
  private String fixedTaxId;
  private DateTime holdDate;
  private String individualName;
  private DateTime lastUpdated;
  private String md5;
  private String protect;
  private String sampleAlias;
  private String sampleTitle;
  private String sampleXml;
  private String scientificName;
  private Integer statusId;
  private String submissionAccountId;
  private String submissionId;
  private String taxId;
  private Integer version;
}
