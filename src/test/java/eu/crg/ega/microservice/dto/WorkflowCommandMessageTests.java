package eu.crg.ega.microservice.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.message.Command;
import eu.crg.ega.microservice.dto.message.CommandMessage;
import eu.crg.ega.microservice.dto.message.MessageHeader;
import eu.crg.ega.microservice.dto.message.Producer;
import eu.crg.ega.microservice.dto.message.WorkFlowCommandMessage;
import eu.crg.ega.microservice.enums.MessageType;
import eu.crg.ega.microservice.enums.PetitionType;
import eu.crg.ega.microservice.enums.WorkflowType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class WorkflowCommandMessageTests {

  @Test
  public void testWorkflowCommand() {
    ObjectMapper mapper = new ObjectMapper();
    WorkFlowCommandMessage message = new WorkFlowCommandMessage();
    message.setMessageType(MessageType.COMMAND);
    message.setCommand(Command.builder().commandType("WORKFLOW").version("v1").build());
    message.setHeader(
        MessageHeader.builder().producer(Producer.builder().application("test").build()).build());
    message.setWorkflowSubtype(WorkflowType.NEW_DOWNLOADBOX);
    message.setRequesterEmail("jordi.rambla@crg.eu");
    message.setPetitionType(PetitionType.STUDY);
    message.setSystemUser("dbox999");
    List<String> infoToAsk = new ArrayList<String>();
    infoToAsk.add("EGAS00001000001");
    message.setInfoAsked(infoToAsk);
    message.setCompress(false);
    String result = null;
    try {
      result = mapper.writeValueAsString((CommandMessage) (message));
      System.out.println(result);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    assertNotNull(result);
    Assert.assertThat(result, CoreMatchers.containsString("workflowId"));
  }

}
