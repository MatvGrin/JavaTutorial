package singletonSecond;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;

//        EmailService email = serviceLocator.getService(EmailService.class);
//        email.sendEmail("Vova@gmail.com", "Hello");
//
//        PaymentService payment = serviceLocator.getService(PaymentService.class);
//        payment.processPayment(50.50);

        Thread thread = new Thread(() -> {
            ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
            EmailService email = serviceLocator.getService(EmailService.class);
            email.sendEmail("Vova@gmail.com", "Hello");
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
            PaymentService payment = serviceLocator.getService(PaymentService.class);
            payment.processPayment(50.50);
        });
        thread2.start();
    }
}
