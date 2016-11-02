package eu.crg.ega.microservice.dto.beacon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error {

  // Numeric status code
  private int errorCode;

  // Error message
  private String message;

}
