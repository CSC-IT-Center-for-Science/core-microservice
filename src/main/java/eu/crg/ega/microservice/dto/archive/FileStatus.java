package eu.crg.ega.microservice.dto.archive;

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
public class FileStatus {
  private Integer statusId;
  private Integer statusCategory;
  private Integer statusNumber;
  private String statusDescription;
  private String statusIntervention;
}
