package eu.crg.ega.microservice.dto.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.microservice.dto.catalog.Packet;
import eu.crg.ega.swaggerconstants.common.dto.SwaggerCommonDtos;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@ApiModel("Request data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class RequestData {

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_DATA_PACKETS, notes = SwaggerCommonDtos.REQUEST_DATA_PACKETS_NOTES, required = true, position = 1)
  private List<Packet> packets;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_DATA_LABEL, notes = SwaggerCommonDtos.REQUEST_DATA_LABEL_NOTES, required = true, position = 2)
  private String label;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_DATA_STATUS, notes = SwaggerCommonDtos.REQUEST_DATA_STATUS_NOTES, required = true, position = 3)
  private String status;


  //Utility methods
  public List<String> getPacketsListWithStableId() {
    List<String> packetsStableId = new ArrayList<String>();

    for (Packet packet : packets) {
      packetsStableId.add(packet.getPacketStableId());
    }

    return packetsStableId;
  }
}
