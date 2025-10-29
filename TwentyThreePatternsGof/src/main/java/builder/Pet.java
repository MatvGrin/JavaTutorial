package builder;

import lombok.ToString;

@ToString
public final class Pet {
    private final String alias;
    private final int age;
    private final String color;

    private Pet(Builder builder) {
        this.alias = builder.alias;
        this.age = builder.age;
        this.color = builder.color;
    }

    public static final class Builder {
        private String alias;
        private int age;
        private String color;

        public Builder() {
        }

        public Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Pet build() {
            return new Pet(this);
        }
    }
}