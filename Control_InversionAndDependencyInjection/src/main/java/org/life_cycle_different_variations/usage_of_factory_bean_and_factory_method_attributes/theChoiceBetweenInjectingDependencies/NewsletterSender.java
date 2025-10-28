package org.life_cycle_different_variations.usage_of_factory_bean_and_factory_method_attributes.theChoiceBetweenInjectingDependencies;

public interface NewsletterSender {
    void setSmtpServer(String smtpServer);

    String getSmtpServer();

    void setFromAddress(String fromAddress);

    String getFromAddress();

    void send();
}
