package org.announcementOfSpringComponents;

public class HelloWorldMessageProvider implements MessageProvider{

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
