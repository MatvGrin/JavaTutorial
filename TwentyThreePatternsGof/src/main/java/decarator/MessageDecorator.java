package decarator;

public class MessageDecorator extends Message {
    private Message message;

    public MessageDecorator(Message message) {
        this.message = message;
    }


    @Override
    public void writeMessage(String message) {
        System.out.print("<<<");
        super.writeMessage(message);
        System.out.print(">>>");
    }
}
