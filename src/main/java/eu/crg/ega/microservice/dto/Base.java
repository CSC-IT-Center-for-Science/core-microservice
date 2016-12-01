package eu.crg.ega.microservice.dto;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.StringUtils;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import eu.crg.ega.microservice.dto.audit.AuditFile;
import eu.crg.ega.microservice.dto.audit.AuditFileStatus;
import eu.crg.ega.microservice.dto.auth.Session;
import eu.crg.ega.microservice.dto.auth.SessionUser;
import eu.crg.ega.microservice.dto.auth.User;
import eu.crg.ega.microservice.dto.catalog.Dac;
import eu.crg.ega.microservice.dto.catalog.Dataset;
import eu.crg.ega.microservice.dto.catalog.File;
import eu.crg.ega.microservice.dto.catalog.Packet;
import eu.crg.ega.microservice.dto.catalog.Study;
import eu.crg.ega.microservice.dto.catalog.SubmittedFile;
import eu.crg.ega.microservice.dto.erapro.Experiment;
import eu.crg.ega.microservice.dto.erapro.Run;
import eu.crg.ega.microservice.dto.erapro.Sample;
import eu.crg.ega.microservice.dto.erapro.Submission;
import eu.crg.ega.microservice.dto.message.NotificationMessage;
import eu.crg.ega.microservice.dto.request.Request;
import eu.crg.ega.microservice.dto.request.RequestData;
import eu.crg.ega.microservice.dto.version.GitRepositoryState;
import eu.crg.ega.microservice.dto.version.MavenEntry;
import eu.crg.ega.microservice.generic.Tuple;
import eu.crg.ega.swaggerconstants.common.dto.SwaggerCommonDtos;

@ApiModel("Base")
@Log4j
@AllArgsConstructor
@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "base")
@XmlSeeAlso(value = {AuditFile.class, AuditFileStatus.class, Dac.class, Dataset.class,
                     Experiment.class, File.class, GitRepositoryState.class,
                     MavenEntry.class, NotificationMessage.class, Packet.class, Request.class,
                     RequestData.class, Response.class,
                     Run.class, Sample.class, ServiceLocation.class, Study.class, Submission.class,
                     SubmittedFile.class,
                     SessionUser.class, User.class, Session.class})
public class Base<T> {

  @ApiModelProperty(value = SwaggerCommonDtos.BASE_HEADER, notes = SwaggerCommonDtos.BASE_HEADER_NOTES, required = true, position = 1)
  @XmlElement(name = "header")
  private Header header;

  @ApiModelProperty(value = SwaggerCommonDtos.BASE_RESPONSE, notes = SwaggerCommonDtos.BASE_RESPONSE_NOTES, required = true, position = 2)
  @XmlElement(name = "response")
  private Response<T> response;

  public Base() {
    this.header = new Header();
    this.response = new Response<T>();
  }

  public Base(Response<T> data) {
    this.header = new Header();
    this.response = data;
  }

  public Base(T data) {
    this.header = new Header();
    List<T> list = new ArrayList<T>(1);
    list.add(data);
    this.response = new Response<T>(data);
  }

  public Base(List<T> data) {
    this(new Response<T>(data));
  }

  public Base(int totalResults, List<T> data) {
    this(new Response<T>(totalResults, data));
  }

  // Method for exceptions
  public Base(String code, Exception e) {
    this(code, e, true);
  }

  public Base(String code, Exception e, Boolean debug) {
    Header header = new Header();
    header.setCode(code);
    header.setErrorCode(code);
    header.setDeveloperMessage(e.toString());
    header.setUserMessage((StringUtils.isNotBlank(e.getLocalizedMessage()) ? e
        .getLocalizedMessage() : e.getClass().toString()));

    //Set ErrorStack
    if (debug) {
      try (
          StringWriter sw = new StringWriter();
          PrintWriter pw = new PrintWriter(sw);
      ) {
        e.printStackTrace(pw);
        String exceptionAsString = sw.toString();
        header.setErrorStack("-- " + exceptionAsString);
      } catch (IOException ex) {
        log.error("Exception getting stack trace", ex);
      }
    }
    this.header = header;
  }

  public Base(Tuple<T> tuple) {
    this(tuple != null ? tuple.getValue() : 0, tuple != null ? tuple.getList() : null);
  }
  
}
