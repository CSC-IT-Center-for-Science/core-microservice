package eu.crg.ega.microservice.dto.submitter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import eu.crg.ega.submissionxsdclasses.DATASETS;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "datasetDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataset_data")
@XmlSeeAlso(value = {CommonData.class, DATASETS.class, AttributeData.class, UrlLink.class})
public class DatasetData extends CommonData {
  
  @XmlElement(name = "xml_root_element")
  private DATASETS xmlRootElement;

  @XmlElement(name = "dataset_type_ids")
  private List<String> datasetTypeIds;
  
  @XmlElement(name = "dataset_types")
  private List<String> datasetTypes;
  
  @XmlElement(name = "policy_id")
  private String policyId;
  
  @XmlElement(name = "runs_references")
  private List<String> runsReferences;
  
  @XmlElement(name = "analysis_references")
  private List<String> analysisReferences;
  
  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "dataset_links")
  private List<UrlLink> datasetLinks = new ArrayList<UrlLink>();
  
  @XmlElement(name = "attributes")
  private List<AttributeData> attributes = new ArrayList<AttributeData>();

}
