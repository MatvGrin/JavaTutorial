package org.introduction_of_collections;

public class LyricHolder implements ContentHolder{
    private String value = "'You bе the DJ, I'll Ье the driver'";

    @Override
    public String toString() {
        return "LyricHolder: { " + value + "} ";
    }
}
