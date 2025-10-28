package org.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MailSubscriber implements ApplicationListener<MailEvent> {
    @Override
    public void onApplicationEvent(MailEvent event) {
        System.out.println("Subscriber received mail: " + event.getMail());
    }
}
