package org.test;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class MailEvent extends ApplicationEvent {
    private Mail mail;
    public MailEvent(Object source, Mail mail) {
        super(source);
        this.mail = mail;
    }
}
