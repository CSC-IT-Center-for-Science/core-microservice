package eu.crg.ega.microservice.exception;

public class NotFoundOrUnauthorizedException extends RuntimeException {

  private static final long serialVersionUID = -6459950316869029941L;
  
  public NotFoundOrUnauthorizedException(String message) {
    super(message);
  }
  
  public NotFoundOrUnauthorizedException(String message, Throwable t) {
    super(message, t);
  }

}
