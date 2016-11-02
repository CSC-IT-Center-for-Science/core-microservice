package eu.crg.ega.microservice.dto.common;

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
public class Status {
  private Integer id;
  private String description;
  private String grouping;
  private String userGrouping;
  private String userGroupingAbridged;
  private String states;
}