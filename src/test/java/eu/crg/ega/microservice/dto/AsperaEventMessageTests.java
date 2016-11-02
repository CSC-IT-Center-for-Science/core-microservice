package eu.crg.ega.microservice.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.message.AsperaEventMessage;
import eu.crg.ega.microservice.dto.message.Event;
import eu.crg.ega.microservice.dto.message.EventMessage;
import eu.crg.ega.microservice.dto.message.MessageHeader;
import eu.crg.ega.microservice.dto.message.Producer;
import eu.crg.ega.microservice.enums.AsperaEventType;
import eu.crg.ega.microservice.enums.EventType;
import eu.crg.ega.microservice.enums.MessageType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class AsperaEventMessageTests {

  @Test
  public void testAsperaEvent() {
    ObjectMapper mapper = new ObjectMapper();
    AsperaEventMessage message = new AsperaEventMessage();
    message.setMessageType(MessageType.EVENT);
    message.setEvent(Event.builder().eventType(EventType.ASPERA).version("v1").build());
    message.setHeader(
        MessageHeader.builder().producer(Producer.builder().application("test").build()).build());
    message.setDirection("send");
    message.setUser("dasads");
    message.setAsperaEventSubtype(AsperaEventType.LOGIN);
    String result = null;
    try {
      result = mapper.writeValueAsString((EventMessage) (message));
      System.out.println(result);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    assertNotNull(result);
    Assert.assertThat(result, CoreMatchers.containsString("targetRate"));
  }

}
