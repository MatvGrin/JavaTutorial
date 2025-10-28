package org.injecting_dependencies_through_the_search_method_with_config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;

public class LookupConfigDemo {
    @Configuration
    @ComponentScan(basePackages = {"org.injecting_dependencies_through_the_search_method_with_config"})
    public static class LookupConfig{}

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(LookupConfig.class);
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
        for (int x = 0; x < 10_000; x++) {
            Singer singer = bean.getMySinger();
            singer.sign();
        }
        stopWatch.stop();
        System.out.println("10_000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
