package org.life_cycle_different_variations.application_of_events_in_applications;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent messageEvent = (MessageEvent) event;
        System.out.println("Received: " + messageEvent.getMessage());
        System.out.println("Book: " + messageEvent.getBook());
        System.out.println("-----------------------");
    }
}
