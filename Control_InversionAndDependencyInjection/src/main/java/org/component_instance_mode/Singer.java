package org.component_instance_mode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("nonSingleton")
@Scope("prototype")
public class Singer {
    private String name = "unknown";

    public Singer(@Value("John Mayer") String name){
        this.name = name;
    }

}

//<beans ... >
//<bean id="nonSingleton" class="org.component_instance_mode.Singer" scope="prototype" с: O="John Mayer"/>
//</beans>