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
public class AuditMd5 {

  private Integer md5Id;
  private String fileStableId;
  private String md5Checksum;
  private String processStep;
  private DateTime timestamp;
}
