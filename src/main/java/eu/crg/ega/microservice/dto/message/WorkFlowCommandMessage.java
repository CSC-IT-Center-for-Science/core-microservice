package eu.crg.ega.microservice.dto.message;

import eu.crg.ega.microservice.dto.message.common.WorkFlowInfo;
import eu.crg.ega.microservice.dto.message.interfaces.WorkflowMessage;
import eu.crg.ega.microservice.enums.PetitionType;
import eu.crg.ega.microservice.enums.WorkflowType;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WorkFlowCommandMessage extends CommandMessage implements WorkflowMessage {

  private WorkFlowInfo workFlowInfo;

  public WorkFlowCommandMessage() {
    super();
    workFlowInfo = new WorkFlowInfo();
  }

  public WorkflowType getWorkflowSubtype() {
    return workFlowInfo.workflowSubtype;
  }

  public void setWorkflowSubtype(WorkflowType workflowEventSubtype) {
    workFlowInfo.workflowSubtype = workflowEventSubtype;
  }

  public WorkflowType getPreviousState() {
    return workFlowInfo.previousState;
  }

  public void setPreviousState(WorkflowType previousState) {
    workFlowInfo.previousState = previousState;
  }

  public String getWorkflowId() {
    return workFlowInfo.workflowId;
  }

  public void setWorkflowId(String workflowId) {
    workFlowInfo.workflowId = workflowId;
  }

  public Integer getErrorCode() {
    return workFlowInfo.errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    workFlowInfo.errorCode = errorCode;
  }

  public String getErrorType() {
    return workFlowInfo.errorType;
  }

  public void setErrorType(String errorType) {
    workFlowInfo.errorType = errorType;
  }

  public String getUserId() {
    return workFlowInfo.userId;
  }

  public void setUserId(String userId) {
    workFlowInfo.userId = userId;
  }

  public String getRequesterEmail() {
    return workFlowInfo.requesterEmail;
  }

  public void setRequesterEmail(String requesterEmail) {
    workFlowInfo.requesterEmail = requesterEmail;
  }

  public PetitionType getPetitionType() {
    return workFlowInfo.petitionType;
  }

  public void setPetitionType(PetitionType petitionType) {
    workFlowInfo.petitionType = petitionType;
  }

  public String getSystemUser() {
    return workFlowInfo.systemUser;
  }

  public void setSystemUser(String systemUser) {
    workFlowInfo.systemUser = systemUser;
  }

  public List<String> getInfoAsked() {
    return workFlowInfo.infoAsked;
  }

  public void setInfoAsked(List<String> infoAsked) {
    workFlowInfo.infoAsked = infoAsked;
  }

  @Override
  public List<String> getEgafFiles() {
    return workFlowInfo.egafFiles;
  }

  @Override
  public void setEgafFiles(List<String> files) {
    workFlowInfo.egafFiles = files;
  }

  @Override
  public List<String> getEgaCrgFiles() {
    return workFlowInfo.egaCrgFiles;
  }

  @Override
  public void setEgaCrgFiles(List<String> files) {
    workFlowInfo.egaCrgFiles = files;
  }

  public Integer getTargetInternalFileId() {
    return workFlowInfo.targetInternalFileId;
  }

  public void setTargetInternalFileId(Integer targetInternalFileId) {
    workFlowInfo.targetInternalFileId = targetInternalFileId;
  }

  public String getSourceFile() {
    return workFlowInfo.sourceFile;
  }

  public void setSourceFile(String sourceFile) {
    workFlowInfo.sourceFile = sourceFile;
  }

  public String getTargetFile() {
    return workFlowInfo.targetFile;
  }

  public void setTargetFile(String targetFile) {
    workFlowInfo.targetFile = targetFile;
  }

  public String getResult() {
    return workFlowInfo.result;
  }

  public void setResult(String result) {
    workFlowInfo.result = result;
  }

  public Integer getDecryptKeyId() {
    return workFlowInfo.decryptKeyId;
  }

  public void setDecryptKeyId(Integer decryptKeyId) {
    workFlowInfo.decryptKeyId = decryptKeyId;
  }

  public String getReEncryptkey() {
    return workFlowInfo.reEncryptkey;
  }

  public void setReEncryptkey(String reEncryptkey) {
    workFlowInfo.reEncryptkey = reEncryptkey;
  }

  @Override
  public String getExclude() {
    return workFlowInfo.exclude;
  }

  @Override
  public void setExclude(String exclude) {
    workFlowInfo.exclude = exclude;
  }

  @Override
  public String getInclude() {
    return workFlowInfo.include;
  }

  @Override
  public void setInclude(String include) {
    workFlowInfo.include = include;
  }

  @Override
  public Integer getPriority() {
    return workFlowInfo.priority;
  }

  @Override
  public void setPriority(Integer priority) {
    workFlowInfo.priority = priority;
  }

  @Override
  public boolean getCompress() {
    return workFlowInfo.compress;
  }

  @Override
  public void setCompress(boolean compress) {
    workFlowInfo.compress = compress;
  }
}
