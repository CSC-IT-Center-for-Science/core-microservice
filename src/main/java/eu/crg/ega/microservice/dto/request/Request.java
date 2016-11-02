package eu.crg.ega.microservice.dto.request;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.microservice.dto.catalog.Dataset;
import eu.crg.ega.microservice.dto.catalog.Packet;
import eu.crg.ega.microservice.enums.RequestStatus;
import eu.crg.ega.swaggerconstants.common.dto.SwaggerCommonDtos;

import org.joda.time.DateTime;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@ApiModel("Request")
@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_ID, notes = SwaggerCommonDtos.REQUEST_ID_NOTES, required = true, position = 1)
  private String id;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_USER_ID, notes = SwaggerCommonDtos.REQUEST_USER_ID_NOTES, required = true, position = 2)
  private String userId;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_LABEL, notes = SwaggerCommonDtos.REQUEST_LABEL_NOTES, required = true, position = 3)
  private String label;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_PACKETS, notes = SwaggerCommonDtos.REQUEST_PACKETS_NOTES, required = true, position = 4)
  private List<Packet> packets;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_DATASET, notes = SwaggerCommonDtos.REQUEST_DATASET_NOTES, required = true, position = 5)
  private Dataset
      dataset;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_STATUS, notes = SwaggerCommonDtos.REQUEST_STATUS_NOTES, required = true, position = 6)
  private RequestStatus status;

  @ApiModelProperty(value = SwaggerCommonDtos.REQUEST_CREATION_TIME, notes = SwaggerCommonDtos.REQUEST_CREATION_TIME_NOTES, required = true, position = 7)
  private DateTime creationTime;
}
