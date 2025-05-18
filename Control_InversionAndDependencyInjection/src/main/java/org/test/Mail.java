package org.test;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.util.Random;
@Data
public class Mail implements InitializingBean, ApplicationContextAware {
    private int id;
    private String message;
    private boolean isProcessed;
    private static final Random RANDOM = new Random();
    private ApplicationContext ctx;

    @Override
    public void afterPropertiesSet() throws Exception {
        id = RANDOM.nextInt(1000);
        Resource res = ctx.getResource("classpath:test.txt");
        message = new String(res.getInputStream().readAllBytes());
    }
    public void initMail() {
        System.out.println("Initializing bean: " + this.getClass());
    }
    public void destroyMail() {
        System.out.println("Called destroy bean: " + this.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", isProcessed=" + isProcessed +
                '}';
    }
}
