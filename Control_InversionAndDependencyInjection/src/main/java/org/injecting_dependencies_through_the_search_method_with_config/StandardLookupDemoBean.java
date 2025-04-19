package org.injecting_dependencies_through_the_search_method_with_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("standardLookupDemoBean")
public class StandardLookupDemoBean implements DemoBean {
    private Singer mySinger;

    @Qualifier("singer")
    @Autowired
    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        mySinger.sign();
    }
}
