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
public class Dataset {

  private String datasetStableId;
  private String dacStableId;
  private String title;
  private String description;
  private String technology;
  private String name;
  private Integer numSamples;
  private Boolean allPacketsSelected = false;
}
