package factoryMethodSecondRealisation;

public class Main {
    public static void main(String[] args) {
        MessageSenderFactory.createMessage("SMS").send("Hi Vova");
        MessageSenderFactory.createMessage("Email").send("Hello Vova");
        MessageSenderFactory.createMessage("Push").send("Bok Vova");
        MessageSenderFactory.createMessage("Hi").send("Pam");
    }
}
