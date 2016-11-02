package eu.crg.ega.microservice.dto;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.swaggerconstants.common.dto.SwaggerCommonDtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("Response")
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Response<T> {

  @ApiModelProperty(value = SwaggerCommonDtos.RESPONSE_NUM_TOTAL_RESULTS, notes = SwaggerCommonDtos.RESPONSE_NUM_TOTAL_RESULTS_NOTES, required = true, position = 1)
  @XmlElement(name = "num_total_results")
  private Integer numTotalResults;

  @ApiModelProperty(value = SwaggerCommonDtos.RESPONSE_RESULT_TYPE, notes = SwaggerCommonDtos.RESPONSE_RESULT_TYPE_NOTES, required = true, position = 2)
  @XmlElement(name = "result_type")
  private String resultType = "";

  @ApiModelProperty(value = SwaggerCommonDtos.RESPONSE_RESULT, notes = SwaggerCommonDtos.RESPONSE_RESULT_NOTES, required = true, position = 3)
  @XmlElement(name = "result")
  private List<T> result;

  public Response() {
    this.numTotalResults = 0;
    this.result = new ArrayList<T>();
  }

  public Response(Integer totalResults, List<T> collection) {
    this.numTotalResults = totalResults;
    this.result = collection;
    this.resultType = collection != null && collection.size() > 0 ? collection.get(0).getClass().getCanonicalName() : "";
  }

  public Response(T data) {
    List<T> list = new ArrayList<T>(1);
    list.add(data);
    this.result = list;
    this.numTotalResults = 1;
    this.resultType = data != null ? data.getClass().getCanonicalName() : "";
  }

  public Response(List<T> data) {
    this.resultType = data.size() > 0 ? data.get(0).getClass().getCanonicalName() : "";
    this.numTotalResults = data.size();
    this.result = data;
  }

}
