package eu.crg.ega.microservice.enums;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Q4AQueryBy {

  ANALYSIS("analysis"),
  DAC("dac"),
  DATASET("dataset"),
  EXPERIMENT("experiment"),
  POLICY("policy"),
  RUN("run"),
  SAMPLE("sample"),
  STUDY("study");

  private String queryBy;

  public static Q4AQueryBy parse(String value) {
    Q4AQueryBy q4AQueryBy = null;
    if (StringUtils.equalsIgnoreCase(value, ANALYSIS.queryBy)) {
      q4AQueryBy = ANALYSIS;
    } else if (StringUtils.equalsIgnoreCase(value, DAC.queryBy)) {
      q4AQueryBy = DAC;
    } else if (StringUtils.equalsIgnoreCase(value, DATASET.queryBy)) {
      q4AQueryBy = DATASET;
    } else if (StringUtils.equalsIgnoreCase(value, EXPERIMENT.queryBy)) {
      q4AQueryBy = EXPERIMENT;
    } else if (StringUtils.equalsIgnoreCase(value, POLICY.queryBy)) {
      q4AQueryBy = POLICY;
    } else if (StringUtils.equalsIgnoreCase(value, RUN.queryBy)) {
      q4AQueryBy = RUN;
    } else if (StringUtils.equalsIgnoreCase(value, SAMPLE.queryBy)) {
      q4AQueryBy = SAMPLE;
    } else if (StringUtils.equalsIgnoreCase(value, STUDY.queryBy)) {
      q4AQueryBy = STUDY;
    }
    return q4AQueryBy;
  }
  
}
