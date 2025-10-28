package org.test;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.life_cycle_different_variations.application_of_events_in_applications.Book;
import org.life_cycle_different_variations.application_of_events_in_applications.MessageEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PostOffice implements DisposableBean, ApplicationContextAware {
    private MailSupplier supplier;
    private MailConsumer consumer;
    private ApplicationContext ctx;

    @Autowired
    public void setSupplier(MailSupplier supplier) {
        this.supplier = supplier;
        System.out.println("Supplier injected");
    }
    @Autowired
    public void setConsumer(MailConsumer consumer) {
        this.consumer = consumer;
        System.out.println("Consumer injected");
    }

    public void handle() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            Mail mail = supplier.supply();
            System.out.println("Post office receive mail: " + mail);
            System.out.println("Start processing!");
            Thread.sleep(3000);
            mail.setProcessed(true);
            consumer.consumer(mail);
            ctx.publishEvent(new MailEvent(this, mail));
        }
    }

    @PostConstruct
    public void setPostConstruct(){
        System.out.println("Called Post Construct" + this.getClass());
    }

    @PreDestroy
    public void setPreDestroy(){
        System.out.println("Called pre destroy: " + this.getClass());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Called method destroy: " + this.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

}
