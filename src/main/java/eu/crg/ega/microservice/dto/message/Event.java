package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.enums.EventType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Event {

  private EventType eventType;

  private String version = "v1";
}
