package org.life_cycle_different_variations.application_of_events_in_applications;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {
    private String msg;
    private Book book;
    public MessageEvent(Object source, String msg, Book book) {
        super(source);
        this.msg = msg;
        this.book = book;
    }
    public String getMessage(){
        return msg;
    }

    public Book getBook() {
        return book;
    }
}
