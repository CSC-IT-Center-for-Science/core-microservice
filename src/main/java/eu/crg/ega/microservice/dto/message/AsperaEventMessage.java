package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.enums.AsperaEventType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AsperaEventMessage extends EventMessage {

  private AsperaEventType asperaEventSubtype;

  //Common
  private String direction;
  private String errorCode = null;
  private String errorString = null;
  private String peer;
  private String startStop;
  private String state;
  private String type;
  private String user;
  private String userId;
  private String userString;

  //Type Session
  private Integer fileCount;
  private Integer minRate;
  private String source;
  private String target;
  private Integer targetRate;
  private Long totalBytes;
  private Long totalSize;

  //Type File
  private String file;
  private Double loss;
  private Double rate;
  private Long size;

}
