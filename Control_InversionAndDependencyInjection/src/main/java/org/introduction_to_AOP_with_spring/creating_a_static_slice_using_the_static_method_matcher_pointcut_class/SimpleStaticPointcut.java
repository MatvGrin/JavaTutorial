package org.introduction_to_AOP_with_spring.creating_a_static_slice_using_the_static_method_matcher_pointcut_class;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return ("sing".equals(method.getName()));
    }

//    @Override
//    public ClassFilter getClassFilter() {
//        return cls -> (cls == GoodGuitarist.class);
//    }

    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            public boolean matches(Class<?> cls){
                return (cls == GoodGuitarist.class);
            }
        };
    }
}
