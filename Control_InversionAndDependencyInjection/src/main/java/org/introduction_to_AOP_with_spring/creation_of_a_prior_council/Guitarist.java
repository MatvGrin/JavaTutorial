package org.introduction_to_AOP_with_spring.creation_of_a_prior_council;

public class Guitarist implements Singer {
    private String lyric = "You're gonna live forever in me";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
