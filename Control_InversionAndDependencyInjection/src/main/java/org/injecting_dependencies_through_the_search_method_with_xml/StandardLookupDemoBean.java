package org.injecting_dependencies_through_the_search_method_with_xml;

public class StandardLookupDemoBean implements DemoBean{
    private Singer mySinger;
    public void setMySinger(Singer mySinger){
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
