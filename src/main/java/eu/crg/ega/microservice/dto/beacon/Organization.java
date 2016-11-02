package eu.crg.ega.microservice.dto.beacon;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

  // Unique identifier of the organization
  private String id;

  // Name of the organization
  private String name;

  // Description of the organization
  private String description;

  // Address of the organization
  private String address;

  // Web of the organization (URL)
  private String welcomeUrl;

  // URL with the contact for the beacon operator/maintainer, e.g. link to a contact form or an
  // email in RFC 2368 scheme
  private String contactUrl;

  // URL to the logo of the organization (image)
  private String logoUrl;

  // Additional structured metadata, key-value pairs
  private Map<String, String> info;

}
