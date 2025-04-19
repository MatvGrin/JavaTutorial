package org.introduction_of_collections_second;

import jakarta.annotation.Resource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("injectCollection")
public class CollectionInjection {
    @Resource(name="map")
    private Map<String, Object> map;
    @Resource(name="props")
    private Properties props;
    @Resource(name="set")
    private Set set;
    @Resource(name="list")
    private List list;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("app-context-xml-collections-second.xml");
        ctx.refresh();
        CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
        instance.displayInfo();
        ctx.close();
    }

    public void displayInfo(){
        System.out.println("Map contents:\n");
        map.entrySet().stream()
                .forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));
        System.out.println("\nProperties contents:\n");
        props.entrySet().stream()
                .forEach(e -> System.out.println("Key: " + e.getKey() + " - Value: " + e.getValue()));
        System.out.println("\nSet contents:\n");
        set.forEach(obj -> System.out.println("Value: "+ obj));
        list.forEach(obj -> System. out. println ( "Value: " + obj));
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
}
