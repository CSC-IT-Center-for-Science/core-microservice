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

@ApiModel("File")
@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File {

  @ApiModelProperty(value = "the dataset stable Id", required = true)
  private String datasetStableId;

  @ApiModelProperty(value = "the packet stable Id", required = true)
  private String packetStableId;

  @ApiModelProperty(value = "the file stable Id", required = true)
  private String fileStableId;

  @ApiModelProperty(value = "the file name", required = true)
  private String filename;

}
