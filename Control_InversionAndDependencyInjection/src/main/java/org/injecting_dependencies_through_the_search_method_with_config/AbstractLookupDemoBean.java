package org.injecting_dependencies_through_the_search_method_with_config;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupDemoBean")
public class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    public Singer getMySinger() {
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sign();
    }
}
