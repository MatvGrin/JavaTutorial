package ua.spring.annotations;

import org.springframework.stereotype.Component;

@Component("gmailService")
public class GmailService implements MailService{

    @Override
    public void sendEmail(String to, String message) {
        System.out.println("Sending email Gmail to " + to + " with message: " + message);
    }
}
