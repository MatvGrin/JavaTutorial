package org.method_substitution;

import java.lang.reflect.Method;

public interface MethodReplacer {
    Object reimplement(Object argO, Method method, Object ... args) throws Throwable;
}
