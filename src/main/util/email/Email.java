package main.util.email;

import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
    private static MimeMessage createEmail(String to) throws MessagingException {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties,null);

        MimeMessage email = new MimeMessage(session);
        InternetAddress recipient = new InternetAddress(to);
        InternetAddress sender = new InternetAddress("development9172@gmail.com");

        email.setFrom(sender);
        email.addRecipient(javax.mail.Message.RecipientType.TO,recipient);
        email.setSubject("Thank you for creating your Zvuk account!");
        email.setText("Zvuk aims to reimagine the way local businesses interact with customers. By joining Zvuk you have taken the next step forward towards the future, thank you! - Jake, Patrick, Artie");

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

    public static void send(String userId)  {
        try {
            Gmail service = CreateGmail.getInstance();
            Message message = createMessageWithEmail(createEmail(userId));
            message = service.users().messages().send("me", message).execute();
        } catch(Exception ignored){}

    }
}