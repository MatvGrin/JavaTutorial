package org.introduction_to_AOP_with_spring.example_of_an_appeal_to_the_AOP;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String... args) {
        Agent target = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);
        Agent proxy = (Agent) pf.getProxy();
        target.speak();
        System.out.println("");
        proxy.speak();
    }
}
