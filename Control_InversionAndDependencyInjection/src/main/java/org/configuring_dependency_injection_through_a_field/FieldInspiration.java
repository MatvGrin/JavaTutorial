package org.configuring_dependency_injection_through_a_field;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInspiration {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("config-annotation.xml");
        ctx.refresh();
        Singer singerBean = ctx.getBean(Singer.class);
        singerBean.sing();
        ctx.close();
    }
}
