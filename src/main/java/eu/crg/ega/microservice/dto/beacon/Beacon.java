package eu.crg.ega.microservice.dto.beacon;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beacon {

  // Unique identifier of the beacon
  private String id;

  // Name of the beacon
  private String name;

  // Version of the API provided by the beacon
  private String apiVersion;

  // Organization owning the beacon
  private Organization organization;

  // Description of the beacon
  private String description;

  // Version of the beacon
  private String version;

  // URL to the welcome page/UI for this beacon
  private String welcomeUrl;

  // Alternative URL to the API, e.g. a restricted version of this beacon
  private String alternativeUrl;

  // The time the beacon was created (ISO 8601 format)
  private String createDateTime;

  // The time this beacon was last updated in ms from the epoch
  private String updateDateTime;

  // Datasets served by the beacon. Any beacon should specify at least one dataset.
  private List<Dataset> datasets;

  // Examples of interesting queries, e.g. a few queries demonstrating different responses.
  private List<BeaconAlleleRequest> sampleAlleleRequests;

  // Additional structured metadata, key-value pairs
  private Map<String, String> info;

}
