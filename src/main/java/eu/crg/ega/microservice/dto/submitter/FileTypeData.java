package eu.crg.ega.microservice.dto.submitter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "file_type_data")
public class FileTypeData {

  @XmlElement(name = "tag")
  private String tag;
  
  @XmlElement(name = "value")
  private String value;
  
  @XmlElement(name = "csv_column_names")
  private List<String> csvColumnNames;
  
  @XmlElement(name = "directory_name")
  private boolean directoryName;
  
}
