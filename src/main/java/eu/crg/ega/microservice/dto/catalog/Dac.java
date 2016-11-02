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
public class Dac {

  private String dacStableId;
  private String name;
  private String url;
  private String description;
  private String email;
  private String phoneNumber;
  private String application;
  private String policy;
  private String contactPerson;

}
