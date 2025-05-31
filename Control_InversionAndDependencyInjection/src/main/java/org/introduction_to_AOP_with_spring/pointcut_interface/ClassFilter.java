package org.introduction_to_AOP_with_spring.pointcut_interface;

public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
