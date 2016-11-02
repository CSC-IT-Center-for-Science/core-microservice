package eu.crg.ega.microservice.service;

import org.apache.log4j.Level;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface LogService {

  /**
   * Returns current log level of the app
   */
  public Level getLoglevel();

  /**
   * Sets the log level of the app to the param
   */
  public void setLoglevel(String level) throws LogLevelFormatException;

  /**
   * Sets the log level of the specific class to the param
   */
  public void setLoglevel(String classname, String level) throws LogLevelFormatException;

  /**
   * Gets list of level params
   */
  public List<String> getLoglevels();

}
