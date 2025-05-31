package org.introduction_to_AOP_with_spring.access_protection_to_methods_using_prior_advice;

public class SecureBean {
    public void writeSecureMessage() {
        System.out.println("Every time I learn something new, it pushes some old stuff out of my brain");
    }
}
