package eu.crg.ega.microservice.mailing;

import java.text.MessageFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import lombok.extern.log4j.Log4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.crg.ega.microservice.dto.message.ServiceMessage;

@Log4j
@Service
public class MailServiceImpl implements MailService {

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void sendNotificationMail(JavaMailSender javaMailSender, ServiceMessage eventMessage, String messageTo,
                                   String messageFrom, String messageSubject, String messageContent) {
    String jsonText = convertToJson(eventMessage);

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    try {
      helper.setTo(new String[]{messageTo, "oscar.martinez@crg.eu"});
      helper.setFrom(messageFrom);
      helper.setSubject(messageSubject);

      helper.setText(MessageFormat.format(messageContent, jsonText), true);

      javaMailSender.send(mimeMessage);
    } catch (MessagingException e) {
      log.error("Exception sending email", e);
    }
  }

  @Override
  public void sendMail(JavaMailSender javaMailSender, String messageTo, String messageFrom,
                       String messageSubject, String messageContent) {
    sendMail(javaMailSender, messageTo, null, messageFrom, messageSubject, messageContent);
  }

  @Override
  public void sendMail(JavaMailSender javaMailSender, String messageTo, String carbonCopyMails, String messageFrom, String messageSubject, String messageContent) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    try {
      helper.setTo(new String[]{messageTo, "oscar.martinez@crg.eu", "sabela.delatorre@crg.eu"});
      helper.setFrom(messageFrom);
      if (!StringUtils.isBlank(carbonCopyMails)) {
        helper.setCc(carbonCopyMails.split(","));
      }
      helper.setSubject(messageSubject);
      helper.setText(messageContent, true);
      javaMailSender.send(mimeMessage);
    } catch (MessagingException e) {
      log.error("Exception sending email", e);
    }
  }

  private String convertToJson(ServiceMessage eventMessage) {
//    ObjectMapper mapper = new ObjectMapper();
    String jsonText = "";
    try {
      jsonText = objectMapper.writeValueAsString(eventMessage);
    } catch (JsonProcessingException e) {
      jsonText = e.getMessage();
      log.error("Exception converting Java object to JSON", e);
    }
    return jsonText;
  }

}
