package singletonSecond;

public class EmailService {
    public void sendEmail(String to, String text) {
        System.out.println("Sending email to " + to + ": " + text);
    }
}
