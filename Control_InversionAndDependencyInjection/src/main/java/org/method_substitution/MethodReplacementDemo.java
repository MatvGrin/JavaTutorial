package org.method_substitution;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-format.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
        ctx.close();
    }
    private static void displayInfo(ReplacementTarget target){
        System.out.println(target.formatMessage("Thanks for playing, try again!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int x = 0; x < 1_000_000; x++) {
//            String out = target.formatMessage("No filter in my head");
//            System.out.println(out);
        }
        stopWatch.stop();
        System.out.println("1_O00_OOO invocations took: " + stopWatch.getTotalTimeMillis() + "ms");
    }
}
