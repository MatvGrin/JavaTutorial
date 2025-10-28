package org.life_cycle_different_variations.configuring_the_application_context_type_in_java.Part1;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
