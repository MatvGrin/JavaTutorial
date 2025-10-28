package org.autowired.auto_linking_spring_beans_components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("gigi")
@Lazy
public class TrickyTarget {
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget(){
        System.out.println("Target.constructor()");
    }

    public TrickyTarget(Foo fooOne){
        System.out.println("Target(Foo) called");
    }

    public TrickyTarget(Foo foo, Bar bar){
        System.out.println("Target(Foo, Bar) called");
    }
    @Autowired
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }
    @Autowired
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        System.out.println("Property fooTwo set");
    }
    @Autowired
    public void setBar(Bar bar){
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("app-context-04-new.xml");
        ctx.refresh();
        TrickyTarget t = ctx.getBean(TrickyTarget.class);
        ctx.close();
    }
}
