package main.util;

import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.util.CreateGmail;


public class Email {
    /**
    private static MimeMessage createEmail(String to) throws MessagingException {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties,null);

        MimeMessage email = new MimeMessage(session);
        InternetAddress recipient = new InternetAddress(to);
        InternetAddress sender = new InternetAddress("development9172@gmail.com");

        email.setFrom(sender);
        email.addRecipient(Message.RecipientType.TO,recipient);
        email.setSubject("Confirm your Zvuk account!");
        email.setText("Development Test Message");

        return email;
    }

    private static Message createMessageWithEmail(MimeMessage email) throws MessagingException, IOException{
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        String encodedEmail = Base64.encodeBase64URLSafeString(buffer.toByteArray());
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    public static void Send(String recipient)throws IOException, MessagingException, GeneralSecurityException {
        Gmail service = CreateGmail.newInstance();
        service.users().messages().send();
    }
*/
}