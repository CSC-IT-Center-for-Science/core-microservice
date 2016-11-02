package eu.crg.ega.microservice.dto.submitter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "file_data")
public class FileData {
  
  @XmlElement(name = "file_id")
  private String fileId;
  
  @XmlElement(name = "source")
  private String source;

  @XmlElement(name = "filename")
  private String fileName;
  
  @XmlElement(name = "checksum")
  private String checksum;
  
  @XmlElement(name = "unencrypted_checksum")
  private String unencryptedChecksum;
  
  @XmlElement(name = "checksum_method")
  private String checksumMethod;
  
  public static List<String> extractFilenames(List<FileData> fileDataList) {
    // TODO replace with lambda expression after upgrading to java 8
    List<String> filenames = Lists.transform(fileDataList, new Function<FileData, String>() {
      @Override
      public String apply(FileData input) {
        return input.getFileName();
      }
    });
    return filenames;
  }
  
}
