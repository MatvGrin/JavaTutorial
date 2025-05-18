package org.life_cycle_different_variations.usage_of_factory_bean_and_factory_method_attributes.theChoiceBetweenInjectingDependencies;

public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;
    public void setEncyclopedia(Encyclopedia encyclopedia){
        this.encyclopedia = encyclopedia;
    }
    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are а waste of money - "
                + "go see the world instead";
    }

}
