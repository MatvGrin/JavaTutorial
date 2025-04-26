package org.naming_beans_components_using_annotations_in_configurations;

import org.springframework.stereotype.Component;

//(1)@Component
//(1)@Component("johnMayer1")
//(1)public class Singer {
//(1)    private String lyric = "We found а message in а bottle we were drinking";
//(1)    private String lyric = "Down there below us, under the clouds";
//(1)    public void sing(){
//(1)        System.out.println(lyric);
//(1)    }
//(1)}

//(2)@Component("johnMayer")
//(2)@Award(prize = {"grammy", "platinum disk"})
//(2)public class Singer {
//(2)   private String lyric = "We found а message in а bottle we were drinking";
//(2)    public void sing(){
//(2)        System.out.println(lyric);
//(2)    }
//(2)}

@Component("johnMayer")
@Trophy(name = {"grammy", "platinum disk"})
public class Singer {
    private String lyric = "We found а message in а bottle we were drinking";
    public void sing(){
        System.out.println(lyric);
    }
}