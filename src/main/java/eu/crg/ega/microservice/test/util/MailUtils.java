package eu.crg.ega.microservice.test.util;

import java.util.Enumeration;

import javax.mail.Header;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;

public class MailUtils {
  
  /**
   * Checks if there is a header called <code>headerName</code> with the content
   * <code>headerContent</code> in the message.
   * 
   * @param sentMessage
   * @param headerName
   * @param expectedContent
   * @return
   * @throws MessagingException
   */
  public static boolean existsHeader(MimeMessage sentMessage, String headerName,
      String expectedContent) throws MessagingException {

    boolean exists = false;

    @SuppressWarnings("unchecked")
    Enumeration<Header> headers = sentMessage.getAllHeaders();

    while (headers.hasMoreElements()) {
      Header header = headers.nextElement();
      if (header.getName().equalsIgnoreCase(headerName)) {
        if (header.getValue().contains(expectedContent)) {
          exists = true;
          break;
        }
      }
    }
    return exists;
  }

  public static boolean checkSubject(MimeMessage sentMessage, String expectedContent)
      throws MessagingException {

    return StringUtils.equals(expectedContent, sentMessage.getSubject());
  }
  
}
