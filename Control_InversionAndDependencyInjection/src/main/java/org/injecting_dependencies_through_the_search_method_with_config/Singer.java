package org.injecting_dependencies_through_the_search_method_with_config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
    private String lyric = "I played а quick game of chess with the salt and pepper shaker";

    public void sign() {
        // закомментировано, поскольку оскверняет
        // вывод на консоль
        System.out.println(lyric);
    }
}
