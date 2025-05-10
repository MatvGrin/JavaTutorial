package org.life_cycle_different_variations.applying_the_bean_name_aware_interface;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {
    private String name;
    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing(){
        System.out.println("Singer " + name + " - sing()");
    }
}
