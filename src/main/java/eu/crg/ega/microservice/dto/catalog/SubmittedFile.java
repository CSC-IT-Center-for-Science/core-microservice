package eu.crg.ega.microservice.dto.catalog;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubmittedFile {

  private String fileHeader;
  private String fileName;
  private String md5;
  private String unencryptedMd5;

}
