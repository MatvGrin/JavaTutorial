package factoryMethodSecondRealisation;

public class MessageSenderFactory {
    public static MessageSender createMessage(String type){
        return switch (type){
            case "Email" -> new EmailSender();
            case "SMS" -> new SmsSender();
            case "Push" -> new PushSender();
            default -> throw new IllegalArgumentException("You are stupid!!!");
        };
    }
}
