package org.spel_value_injection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component("injectSimpleConfig2")
public class InjectSimpleConfig2 {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageInSeconds;
}
