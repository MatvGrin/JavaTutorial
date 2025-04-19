package org.contextualDependencySearch;

public class Dependency {
    private final String name;

    public Dependency(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "name='" + name + '\'' +
                '}';
    }
}
