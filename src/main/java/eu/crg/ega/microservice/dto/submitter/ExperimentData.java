package eu.crg.ega.microservice.dto.submitter;

import java.math.BigInteger;
import java.util.Set;

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
import eu.crg.ega.submissionxsdclasses.EXPERIMENTSET;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "experimentDataBuilder")
@ToString
@EqualsAndHashCode(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "experiment_data")
@XmlSeeAlso(value = {CommonData.class, EXPERIMENTSET.class})
public class ExperimentData extends CommonData {
  
  @XmlElement(name = "ega_accession_ids")
  private Set<String> egaAccessionIds;
  
  @XmlElement(name = "xml_root_element")
  private EXPERIMENTSET xmlRootElement;

  @XmlElement(name = "title")
  private String title;
  
  @XmlElement(name = "instrument_platform")
  private String instrumentPlatform;
  
  @XmlElement(name = "instrument_model_id")
  private String instrumentModelId;
  
  @XmlElement(name = "instrument_model")
  private String instrumentModel;
  
  @XmlElement(name = "library_source_id")
  private String librarySourceId;
  
  @XmlElement(name = "library_source")
  private String librarySource;
  
  @XmlElement(name = "library_selection_id")
  private String librarySelectionId;
  
  @XmlElement(name = "library_selection")
  private String librarySelection;
  
  @XmlElement(name = "library_strategy_id")
  private String libraryStrategyId;
  
  @XmlElement(name = "library_strategy")
  private String libraryStrategy;
  
  @XmlElement(name = "design_description")
  private String designDescription;
  
  @XmlElement(name = "library_name")
  private String libraryName;
  
  @XmlElement(name = "library_construction_protocol")
  private String libraryConstructionProtocol;
  
  @XmlElement(name = "library_layout_id")
  private String libraryLayoutId;
  
  @XmlElement(name = "library_layout")
  private String libraryLayout;
  
  @XmlElement(name = "paired_mominal_length")
  private BigInteger pairedNominalLength;
  
  @XmlElement(name = "paired_nominal_sdev")
  private double pairedNominalSdev;

  @XmlElement(name = "sample_id")
  private String sampleId;
  
  @XmlElement(name = "sample_alias")
  private String sampleAlias;
  
  @XmlElement(name = "study_id")
  private String studyId;
  
  @XmlElement(name = "study_alias")
  private String studyAlias;
  
  @XmlElement(name = "generated_experiment_ids")
  private Set<String> generatedExperimentIds;

  @XmlElement(name = "global_experiment_id")
  private String globalExperimentId;
  
}
