package org.introduction_to_AOP_with_spring.creation_of_a_prior_council;

import org.springframework.aop.framework.ProxyFactory;

public class Demo {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }
}
