package org.life_cycle_different_variations.example_of_using_profiles_in_spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.life_cycle_different_variations.configuring_spring_profiles_in_the_Java_language.HighschoolConfig;
import org.life_cycle_different_variations.configuring_spring_profiles_in_the_Java_language.KindergartenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={KindergartenConfig.class, HighschoolConfig.class})
@ActiveProfiles("kindergarten")
public class ProfilesJavaConfigTest {
    @Autowired
    FoodProviderService foodProviderService;
    @Test
    public void testProvider () {
        assertTrue(
                foodProviderService.provideLunchSet() != null);
        assertFalse(
                foodProviderService.provideLunchSet().isEmpty());
        assertEquals(2,
                foodProviderService.provideLunchSet().size());
    }
}