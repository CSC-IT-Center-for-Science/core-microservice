package eu.crg.ega.microservice.dto.audit;

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
public class AuditFile {

  private Integer fileId;
  private String fileName;
  private String stableId;
  private String fileSize;
  private Integer archiveStatusId;
  private Integer archiveFileId;
  private String packetStableId;
  private String stagingSource;
  private Integer filePriority;
  private String fileType;
  private String objectAccession;
  private DateTime eraproTimestamp;
  private DateTime fileCreated;
  private DateTime fileUpdated;
  private String submissionAccountId;

}
