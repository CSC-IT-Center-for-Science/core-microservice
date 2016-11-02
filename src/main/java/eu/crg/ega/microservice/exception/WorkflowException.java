package eu.crg.ega.microservice.exception;

public class WorkflowException extends RuntimeException {

  private Integer errorCode;

  public WorkflowException(Integer errorCode, String errorType) {
    super(errorType);
    this.errorCode = errorCode;
  }

  public Integer getErrorCode() {
    return this.errorCode;
  }

}
