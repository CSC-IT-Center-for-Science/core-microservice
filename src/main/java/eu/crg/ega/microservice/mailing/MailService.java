package eu.crg.ega.microservice.mailing;

import org.springframework.mail.javamail.JavaMailSender;

import eu.crg.ega.microservice.dto.message.ServiceMessage;

public interface MailService {

  public void sendNotificationMail(JavaMailSender javaMailSender, ServiceMessage eventMessage,
                                   String messageTo, String messageFrom, String messageSubject, String messageContent);

  public void sendMail(JavaMailSender javaMailSender, String messageTo, String messageFrom, String messageSubject, String messageContent);

  public void sendMail(JavaMailSender javaMailSender, String messageTo, String carbonCopyMails, String messageFrom, String messageSubject, String messageContent);
}