/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author ChiNguyen
 */
public class EmailSending {
  
    
    public static void sendTextEmail(String subject, String content, String recipientEmail) {
        Email email = new SimpleEmail();
        
        email.setHostName(MailInfor.HOST_NAME);
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(MailInfor.EMAIL_SENDER, MailInfor.PASSWORD));
        email.setSSLOnConnect(true);
        
        try {
            email.setFrom(MailInfor.EMAIL_SENDER);
            email.setSubject(subject);
            email.setMsg(content);
            email.addTo(recipientEmail);
            
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailSending.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
