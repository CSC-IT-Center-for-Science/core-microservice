package eu.crg.ega.microservice.dto.archive;


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
public class Key {
  private Integer keyId;
  private String keyName;
  private String keyEncryptionType;
  private Integer keyLength;
  private String keyPath;
  private String keyPassword;
  private String userId;
}
