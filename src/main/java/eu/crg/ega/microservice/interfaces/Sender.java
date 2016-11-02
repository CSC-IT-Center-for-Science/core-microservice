package eu.crg.ega.microservice.interfaces;

public interface Sender<U, V, W> {

  public U send(String dest, V param, W event);

}
