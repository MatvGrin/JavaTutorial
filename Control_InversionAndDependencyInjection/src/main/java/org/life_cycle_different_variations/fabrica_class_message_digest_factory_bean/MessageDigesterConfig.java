package org.life_cycle_different_variations.fabrica_class_message_digest_factory_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

@Configuration
public class MessageDigesterConfig {
    @Bean
    public MessageDigestFactoryBean shaDigest(){
        MessageDigestFactoryBean factoryOne = new MessageDigestFactoryBean();
        factoryOne.setAlgorithmName("SHA1");
        return factoryOne;
    }
    @Bean
    public MessageDigestFactoryBean defaultDigest(){
        return new MessageDigestFactoryBean();
    }
    @Bean
    MessageDigester digester() throws Exception{
        MessageDigester messageDigester = new MessageDigester();
        messageDigester.setDigest1(shaDigest().getObject());
        messageDigester.setDigest2(defaultDigest().getObject());
        return messageDigester;
    }

}
