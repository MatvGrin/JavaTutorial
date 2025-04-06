package ua.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;

@Component
public class MailClient {
//    @Autowired
//    @Qualifier("gmailService")
    private MailService mailService;

//    @Resource(name = "outlookService")
    private MailService resourceMailService;

    @Autowired
    private List<MailService> mailServiceList;

    @Autowired
    public MailClient(@Qualifier("gmailService") MailService mailService) {
        this.mailService = mailService;
    }

    public void processMail() {
        mailService.sendEmail("user@example.com", "Hello from @Autowired!");
        resourceMailService.sendEmail("user3@example.com", "Hello from @Resource!");
        for (MailService service : mailServiceList) {
            service.sendEmail("user@example.com", "Hello from @Autowired!");
        }
    }

    @Autowired
    public void setResourceMailService(@Qualifier("outlookService") MailService resourceMailService) {
        this.resourceMailService = resourceMailService;
    }
//
//    @Bean
//    public MailClient mailClient() {
//        MailClient client = new MailClient(gmailService());
//        client.setResourceMailService(outlookService());
//        return client;
//    }
}
