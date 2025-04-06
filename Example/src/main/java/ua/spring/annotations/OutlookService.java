package ua.spring.annotations;

import org.springframework.stereotype.Component;

@Component("outlookService")
public class OutlookService implements MailService{
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("Sending email via Outlook to " + to + " with message: " + message);
    }
}
