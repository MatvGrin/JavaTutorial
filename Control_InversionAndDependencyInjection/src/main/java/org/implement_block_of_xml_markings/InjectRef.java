package org.implement_block_of_xml_markings;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-third.xml");
        ctx.refresh();
        InjectRef injectRef = ctx.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef);
        ctx.close();
    }

    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
