package org.introduction_to_AOP_with_spring.creation_of_a_post_return_council;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static org.introduction_to_AOP_with_spring.creation_of_a_post_return_council.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();
            if (key == WEAK_KEY) {
                throw new SecurityException("Key Generator generated а weak key. Try again");
            }
        }
    }
}
