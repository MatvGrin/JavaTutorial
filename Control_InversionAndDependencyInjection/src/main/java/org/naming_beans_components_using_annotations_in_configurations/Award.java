package org.naming_beans_components_using_annotations_in_configurations;

import org.springframework.core.annotation.AliasFor;

public @interface Award {
    @AliasFor("prize")
    String[] value() default {};

    @AliasFor("value")
    String[] prize() default {};
}
