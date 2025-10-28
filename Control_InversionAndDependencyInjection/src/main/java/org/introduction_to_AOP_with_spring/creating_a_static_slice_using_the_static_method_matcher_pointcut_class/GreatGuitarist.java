package org.introduction_to_AOP_with_spring.creating_a_static_slice_using_the_static_method_matcher_pointcut_class;

import org.introduction_to_AOP_with_spring.creation_of_a_prior_council.Singer;

public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n"
                + "But I did not shoot the deputy");
    }
}
