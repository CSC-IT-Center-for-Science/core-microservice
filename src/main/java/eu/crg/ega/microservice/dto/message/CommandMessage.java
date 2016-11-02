package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.enums.MessageType;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class CommandMessage extends ServiceMessage {

  private Command command;

  private List<String> parameters;

  public CommandMessage(Command command, List<String> parameters) {
    this.setMessageType(MessageType.COMMAND);
    this.command = command;
    this.parameters = parameters;

  }
}
