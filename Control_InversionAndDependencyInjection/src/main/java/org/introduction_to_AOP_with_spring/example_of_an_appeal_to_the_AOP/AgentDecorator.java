package org.introduction_to_AOP_with_spring.example_of_an_appeal_to_the_AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("James ");
        Object retVal = invocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
