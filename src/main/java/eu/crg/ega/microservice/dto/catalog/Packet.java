package eu.crg.ega.microservice.dto.catalog;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@ApiModel("Packet")
@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Packet {

  @ApiModelProperty(value = "the dataset stable Id", required = true)
  private String datasetStableId;

  @ApiModelProperty(value = "the packet stable Id", required = true)
  private String packetStableId;

  private String packageName;

  private String packetName;

  private String description;

  private String type;

  private String technology;

  private String format;

  private int sampleCount;

  public Packet(String packetStableId) {
    this(null, packetStableId);
  }

  public Packet(String datasetStableId, String packetStableId) {
    this.datasetStableId = datasetStableId;
    this.packetStableId = packetStableId;
  }

}
