package eu.crg.ega.microservice.helper;


import eu.crg.ega.microservice.dto.message.Command;
import eu.crg.ega.microservice.dto.message.Event;
import eu.crg.ega.microservice.dto.message.MessageHeader;
import eu.crg.ega.microservice.dto.message.Producer;
import eu.crg.ega.microservice.dto.message.WorkFlowCommandMessage;
import eu.crg.ega.microservice.dto.message.WorkFlowEventMessage;
import eu.crg.ega.microservice.enums.EventType;
import eu.crg.ega.microservice.enums.MessageType;
import eu.crg.ega.microservice.exception.PreConditionFailed;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.log4j.Log4j;

@Log4j
public class WorkflowHelper {

  public void checkWorkflowId(String workflowId) {
    if (StringUtils.isBlank(workflowId)) {
      log.trace("Missing workflow id");
      //reject message
      throw new PreConditionFailed("Missing workflow id");
    }
  }

  public WorkFlowEventMessage createWfEventMessage() {
    WorkFlowEventMessage workFlowEventMessage = new WorkFlowEventMessage();
    workFlowEventMessage.setMessageType(MessageType.EVENT);
    workFlowEventMessage
        .setEvent(Event.builder().eventType(EventType.WORKFLOW).version("v1").build());
    workFlowEventMessage.setHeader(
        MessageHeader.builder()
            .producer(Producer.builder().application("app").build())
            .build());
    return workFlowEventMessage;
  }

  public WorkFlowCommandMessage createWfCommandMessage() {
    WorkFlowCommandMessage workFlowCommandMessage = new WorkFlowCommandMessage();
    workFlowCommandMessage.setMessageType(MessageType.COMMAND);
    workFlowCommandMessage.setCommand(Command.builder().commandType("WORKFLOW").build());
    workFlowCommandMessage.setHeader(
        MessageHeader.builder()
            .producer(Producer.builder().application("app").build())
            .build());
    return workFlowCommandMessage;
  }

  public WorkFlowEventMessage createWfEventMessage(final WorkFlowEventMessage originalMessage) {
    WorkFlowEventMessage workFlowEventMessage = createWfEventMessage();
    workFlowEventMessage.setWorkflowId(originalMessage.getWorkflowId());
    workFlowEventMessage.setInfoAsked(originalMessage.getInfoAsked());
    workFlowEventMessage.setSystemUser(originalMessage.getSystemUser());
    workFlowEventMessage.setPetitionType(originalMessage.getPetitionType());
    workFlowEventMessage.setRequesterEmail(originalMessage.getRequesterEmail());
    workFlowEventMessage.setUserId(originalMessage.getUserId());
    workFlowEventMessage.setEgaCrgFiles(originalMessage.getEgaCrgFiles());
    workFlowEventMessage.setEgafFiles(originalMessage.getEgafFiles());
    workFlowEventMessage.setResult(originalMessage.getResult());
    workFlowEventMessage.setDecryptKeyId(originalMessage.getDecryptKeyId());
    workFlowEventMessage.setReEncryptkey(originalMessage.getReEncryptkey());
    workFlowEventMessage.setTargetInternalFileId(originalMessage.getTargetInternalFileId());
    workFlowEventMessage.setSourceFile(originalMessage.getSourceFile());
    workFlowEventMessage.setTargetFile(originalMessage.getTargetFile());
    workFlowEventMessage.setExclude(originalMessage.getExclude());
    workFlowEventMessage.setInclude(originalMessage.getInclude());
    workFlowEventMessage.setPriority(originalMessage.getPriority());
    workFlowEventMessage.setCompress(originalMessage.getCompress());
    return workFlowEventMessage;
  }

  public WorkFlowEventMessage createWfEventMessage(final WorkFlowCommandMessage originalMessage) {
    WorkFlowEventMessage workFlowEventMessage = createWfEventMessage();
    workFlowEventMessage.setWorkflowId(originalMessage.getWorkflowId());
    workFlowEventMessage.setInfoAsked(originalMessage.getInfoAsked());
    workFlowEventMessage.setSystemUser(originalMessage.getSystemUser());
    workFlowEventMessage.setPetitionType(originalMessage.getPetitionType());
    workFlowEventMessage.setRequesterEmail(originalMessage.getRequesterEmail());
    workFlowEventMessage.setUserId(originalMessage.getUserId());
    workFlowEventMessage.setEgaCrgFiles(originalMessage.getEgaCrgFiles());
    workFlowEventMessage.setEgafFiles(originalMessage.getEgafFiles());
    workFlowEventMessage.setResult(originalMessage.getResult());
    workFlowEventMessage.setDecryptKeyId(originalMessage.getDecryptKeyId());
    workFlowEventMessage.setReEncryptkey(originalMessage.getReEncryptkey());
    workFlowEventMessage.setTargetInternalFileId(originalMessage.getTargetInternalFileId());
    workFlowEventMessage.setSourceFile(originalMessage.getSourceFile());
    workFlowEventMessage.setTargetFile(originalMessage.getTargetFile());
    workFlowEventMessage.setExclude(originalMessage.getExclude());
    workFlowEventMessage.setInclude(originalMessage.getInclude());
    workFlowEventMessage.setPriority(originalMessage.getPriority());
    workFlowEventMessage.setCompress(originalMessage.getCompress());
    return workFlowEventMessage;
  }

  public WorkFlowCommandMessage createWfCommandMessage(final WorkFlowCommandMessage originalMessage) {
    WorkFlowCommandMessage WorkFlowCommandMessage = createWfCommandMessage();
    WorkFlowCommandMessage.setWorkflowId(originalMessage.getWorkflowId());
    WorkFlowCommandMessage.setInfoAsked(originalMessage.getInfoAsked());
    WorkFlowCommandMessage.setSystemUser(originalMessage.getSystemUser());
    WorkFlowCommandMessage.setPetitionType(originalMessage.getPetitionType());
    WorkFlowCommandMessage.setRequesterEmail(originalMessage.getRequesterEmail());
    WorkFlowCommandMessage.setUserId(originalMessage.getUserId());
    WorkFlowCommandMessage.setEgaCrgFiles(originalMessage.getEgaCrgFiles());
    WorkFlowCommandMessage.setEgafFiles(originalMessage.getEgafFiles());
    WorkFlowCommandMessage.setResult(originalMessage.getResult());
    WorkFlowCommandMessage.setDecryptKeyId(originalMessage.getDecryptKeyId());
    WorkFlowCommandMessage.setReEncryptkey(originalMessage.getReEncryptkey());
    WorkFlowCommandMessage.setTargetInternalFileId(originalMessage.getTargetInternalFileId());
    WorkFlowCommandMessage.setSourceFile(originalMessage.getSourceFile());
    WorkFlowCommandMessage.setTargetFile(originalMessage.getTargetFile());
    WorkFlowCommandMessage.setExclude(originalMessage.getExclude());
    WorkFlowCommandMessage.setInclude(originalMessage.getInclude());
    WorkFlowCommandMessage.setPriority(originalMessage.getPriority());
    WorkFlowCommandMessage.setCompress(originalMessage.getCompress());
    return WorkFlowCommandMessage;
  }

  public WorkFlowCommandMessage createWfCommandMessage(final WorkFlowEventMessage originalMessage) {
    WorkFlowCommandMessage WorkFlowCommandMessage = createWfCommandMessage();
    WorkFlowCommandMessage.setWorkflowId(originalMessage.getWorkflowId());
    WorkFlowCommandMessage.setInfoAsked(originalMessage.getInfoAsked());
    WorkFlowCommandMessage.setSystemUser(originalMessage.getSystemUser());
    WorkFlowCommandMessage.setPetitionType(originalMessage.getPetitionType());
    WorkFlowCommandMessage.setRequesterEmail(originalMessage.getRequesterEmail());
    WorkFlowCommandMessage.setUserId(originalMessage.getUserId());
    WorkFlowCommandMessage.setEgaCrgFiles(originalMessage.getEgaCrgFiles());
    WorkFlowCommandMessage.setEgafFiles(originalMessage.getEgafFiles());
    WorkFlowCommandMessage.setResult(originalMessage.getResult());
    WorkFlowCommandMessage.setDecryptKeyId(originalMessage.getDecryptKeyId());
    WorkFlowCommandMessage.setReEncryptkey(originalMessage.getReEncryptkey());
    WorkFlowCommandMessage.setTargetInternalFileId(originalMessage.getTargetInternalFileId());
    WorkFlowCommandMessage.setSourceFile(originalMessage.getSourceFile());
    WorkFlowCommandMessage.setTargetFile(originalMessage.getTargetFile());
    WorkFlowCommandMessage.setExclude(originalMessage.getExclude());
    WorkFlowCommandMessage.setInclude(originalMessage.getInclude());
    WorkFlowCommandMessage.setPriority(originalMessage.getPriority());
    WorkFlowCommandMessage.setCompress(originalMessage.getCompress());
    return WorkFlowCommandMessage;
  }
}