package org.introduction_to_AOP_with_spring.creation_of_a_prior_council;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar.");
    }
}
