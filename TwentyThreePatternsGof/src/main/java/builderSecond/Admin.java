package builderSecond;

import builder.Pet;
import lombok.ToString;

@ToString
public class Admin {
    private final String name;
    private final String surname;
    private final int age;
    private final int password;

    private Admin(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.password = builder.password;
    }

    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private int password;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder password(int password) {
            this.password = password;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
