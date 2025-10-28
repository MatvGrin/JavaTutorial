package org.injecting_dependencies_through_the_search_method_with_xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-search-method.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo("abstractLookupDemoBean", abstractBean);
        displayInfo("standardLookupDemoBean", standardBean);
        ctx.close();
    }

    public static void displayInfo(String beanName, DemoBean bean){
        Singer singer1 = bean.getMySinger();
        Singer singer2 = bean.getMySinger();
        System.out.println("" + beanName + ": " + "Singer Instances the Same?" + (singer1==singer2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 100000; x++) {
            Singer singer = bean.getMySinger();
            singer.sign();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
