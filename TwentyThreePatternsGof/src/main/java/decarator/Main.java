package decarator;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        MessageDecorator messageDecorator = new MessageDecorator(message);

        Mobile mobile = new Mobile();

        mobile.sendMessage(messageDecorator);

        mobile.sendMessage(message);
    }
}
