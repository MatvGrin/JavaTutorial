package org.introduction_to_AOP_with_spring.pointcut_interface;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;

public interface Pointcut {
    ClassFilter getClassFilter ();
    MethodMatcher getMethodMatcher();
}
