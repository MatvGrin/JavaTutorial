package org.naming_beans_components_using_annotations_in_configurations;

import org.springframework.core.annotation.AliasFor;

@Award
public @interface Trophy {
    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default{};
}
