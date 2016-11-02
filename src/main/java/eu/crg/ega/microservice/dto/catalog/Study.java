package eu.crg.ega.microservice.dto.catalog;

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
public class Study {

  private String stableId;
  private String title;
  private String type;
  private String alternativeStableId;
  private String description;
  private String dataProvider;
  private String link;
}
