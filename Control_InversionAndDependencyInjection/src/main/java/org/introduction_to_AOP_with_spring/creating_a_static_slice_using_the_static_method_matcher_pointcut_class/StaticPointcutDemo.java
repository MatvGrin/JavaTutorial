package org.introduction_to_AOP_with_spring.creating_a_static_slice_using_the_static_method_matcher_pointcut_class;

import org.aopalliance.aop.Advice;
import org.introduction_to_AOP_with_spring.creation_of_a_prior_council.Singer;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();
        Singer proxyOne;
        Singer proxyTwo;
        Pointcut pc= new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);
        proxyOne = (Singer)pf.getProxy();
        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(ericClapton);
        proxyTwo = (Singer)pf.getProxy();
        proxyOne.sing();
        proxyTwo.sing();
    }
}
