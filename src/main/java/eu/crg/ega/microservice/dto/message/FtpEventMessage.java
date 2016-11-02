package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.enums.FtpEventSubType;

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
public class FtpEventMessage extends EventMessage {

  private FtpEventSubType eventSubType;

}
