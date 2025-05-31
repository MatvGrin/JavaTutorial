package org.introduction_to_AOP_with_spring.creating_a_dynamic_slice_using_the_dynamic_method_matcher_pointcut_class;

public class SampleBean {
    public void foo(int х) {
        System.out.println("Invoked foo() with: "+ х);
    }
    public void bar() {
        System.out.println("Invoked bar()");
    }
}
