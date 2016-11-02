package eu.crg.ega.microservice.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.message.Event;
import eu.crg.ega.microservice.dto.message.EventMessage;
import eu.crg.ega.microservice.dto.message.FileEventMessage;
import eu.crg.ega.microservice.dto.message.MessageHeader;
import eu.crg.ega.microservice.dto.message.Producer;
import eu.crg.ega.microservice.enums.ArchiveIdTypes;
import eu.crg.ega.microservice.enums.ArchiveSourceTypes;
import eu.crg.ega.microservice.enums.EventType;
import eu.crg.ega.microservice.enums.FileEventType;
import eu.crg.ega.microservice.enums.MessageType;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class FileEventMessageTests {

  @Test
  public void testFileEvent() {
    ObjectMapper mapper = new ObjectMapper();
    FileEventMessage f = new FileEventMessage();
    f.setMessageType(MessageType.EVENT);
    f.setArchiveIdTypes(ArchiveIdTypes.CRG_ACCESSION_ID);
    f.setArchiveSourceTypes(ArchiveSourceTypes.CRG_ARCHIVE);
    f.setEvent(Event.builder().eventType(EventType.FILE).version("v1").build());
    f.setFileEventSubtype(FileEventType.UPDATE);
    f.setHeader(
        MessageHeader.builder().producer(Producer.builder().application("test").build()).build());
    String result = null;
    try {
      result = mapper.writeValueAsString((EventMessage)(f));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    assertNotNull(result);
    Assert.assertThat(result, CoreMatchers.containsString("CRG_ACCESSION_ID"));
  }

}
