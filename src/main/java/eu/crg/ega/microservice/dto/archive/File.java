package eu.crg.ega.microservice.dto.archive;

import java.math.BigInteger;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

import org.joda.time.DateTime;

@Builder
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File {
  private String objectId;
  private Integer fileId;
  private DateTime fileOsCreationTimestamp;
  private DateTime fileOsModificationTimestamp;
  private String fileName;
  private String fileFullpath;
  private String fileRelativePath;
  private String fileExtension;
  private String fileExtensionVersion;
  private BigInteger fileSize;
  private Integer status;
  private String md5Enc;
  private String md5Unc;
  private String crgStableId;
  private Integer key;
  private String source;
  private String ebiStableId;
  private String ebiFullpath;
  private Integer ebiStatus;
  private DateTime created;
  private DateTime updated;
  private DateTime startDate;
  private DateTime endDate;
  private Boolean currentFlag;
  private String owner;
  private String userId;
  private UUID correlationId;
  private Integer keyCrgEncryptionKey;
  private String box;
  private Integer lockingStatus;
}
