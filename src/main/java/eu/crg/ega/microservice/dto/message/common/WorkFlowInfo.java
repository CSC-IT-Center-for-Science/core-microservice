package eu.crg.ega.microservice.dto.message.common;

import eu.crg.ega.microservice.enums.PetitionType;
import eu.crg.ega.microservice.enums.WorkflowType;

import java.util.List;

//If you add a field here, also add it to the WorkflowMessage interface, implementations and WorkflowHelper
public class WorkFlowInfo {

  public WorkflowType workflowSubtype;

  //Common
  public WorkflowType previousState;
  public String workflowId;
  public Integer errorCode;
  public String errorType;
  public String userId;
  public Integer priority; //manual priority

  //For starting a request
  public String requesterEmail;
  public PetitionType petitionType;
  public String systemUser;
  public List<String> infoAsked;
  public String include;
  public String exclude;

  //For passing the information about what is needed or what will be done
  public List<String> egafFiles;
  public List<String> egaCrgFiles;

  //For knowing what to do: route!!!!!!

  //For knowing where to do it
  public Integer targetInternalFileId;

  public String sourceFile;
  public String targetFile;

  //For knowing the result of the step
  public String result;

  //The key to use to decrypt
  public Integer decryptKeyId;

  //The key to use to reencrypt
  public String reEncryptkey;

  //To know if the file has to be compressed
  public Boolean compress = false;
}
//If you add a field here, also add it to the WorkflowMessage interface, implementations and WorkflowHelper