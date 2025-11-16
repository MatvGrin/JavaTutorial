package factoryMethodSecondRealisation;

public class PushSender implements MessageSender{
    @Override
    public void send(String message) {
        System.out.println("Push sender");
    }
}
