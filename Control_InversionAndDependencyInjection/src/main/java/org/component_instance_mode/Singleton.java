package org.component_instance_mode;

public class Singleton {
    private static Singleton instance;

    static{
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }

    private Singleton(){

    }
}
