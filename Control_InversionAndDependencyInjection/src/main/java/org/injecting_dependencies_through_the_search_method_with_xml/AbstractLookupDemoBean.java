package org.injecting_dependencies_through_the_search_method_with_xml;

public abstract class AbstractLookupDemoBean implements DemoBean{
    public abstract Singer getMySinger();
    @Override
    public void doSomething(){
        getMySinger().sign();
    }
}
