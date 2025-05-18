package org.test;

import org.springframework.stereotype.Component;

@Component
public class CityConsumer implements MailConsumer{
    @Override
    public void consumer(Mail mail) {
        System.out.println("Consumer receive mail!!!!!!!!!!\n" + mail);
    }
}
