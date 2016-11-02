package eu.crg.ega.microservice.dto.message.interfaces;

import eu.crg.ega.microservice.enums.PetitionType;

import java.util.List;

public interface WorkflowMessage {
  void setWorkflowId(String workflowId);

  Integer getErrorCode();

  void setErrorCode(Integer errorCode);

  String getErrorType();

  void setErrorType(String errorType);

  String getUserId();

  void setUserId(String userId);

  String getRequesterEmail();

  void setRequesterEmail(String requesterEmail);

  PetitionType getPetitionType();

  void setPetitionType(PetitionType petitionType);

  String getSystemUser();

  void setSystemUser(String systemUser);

  List<String> getInfoAsked();

  void setInfoAsked(List<String> infoAsked);

  List<String> getEgafFiles();

  void setEgafFiles(List<String> files);

  List<String> getEgaCrgFiles();

  void setEgaCrgFiles(List<String> files);

  Integer getTargetInternalFileId();

  void setTargetInternalFileId(Integer targetInternalFileId);

  String getSourceFile();

  void setSourceFile(String sourceFile);

  String getTargetFile();

  void setTargetFile(String targetFile);

  String getResult();

  void setResult(String result);

  Integer getDecryptKeyId();

  void setDecryptKeyId(Integer decryptKeyId);

  String getReEncryptkey();

  void setReEncryptkey(String reEncryptkey);

  String getExclude();

  void setExclude(String exclude);

  String getInclude();

  void setInclude(String include);

  Integer getPriority();

  void setPriority(Integer priority);

  boolean getCompress();

  void setCompress(boolean compress);
}
