package org.life_cycle_different_variations.abstraction_through_interfaces_environment_and_propertySource;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentSampleFirst {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        Map<String, Object> аррМар = new HashMap<>();
        аррМар.put("user.home", "application_home");
        System.out.println("user.home: "
                + System.getProperty("user.home"));
        System.out.println("JAVA_HOME: "
                + System.getenv("JAVA_HOME"));
        System.out.println("user.home: "
                + env.getProperty("user.home"));
        System.out.println("JAVA_HOME: "
                + env.getProperty("JAVA_HOME"));
        ctx.close();
    }
}
