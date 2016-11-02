package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.enums.FtpEventSubType;
import eu.crg.ega.microservice.enums.StatusNotification;

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
public class NotificationMessage<T> {

  private String id;

  private String userId;

  private T serviceMessage;

  private StatusNotification status;

  private FtpEventSubType notificationType;
}
