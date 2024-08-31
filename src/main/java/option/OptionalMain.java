package option;

import test.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Optional<String> optionalWithValue = Optional.of("Hello");
        if (optionalWithValue.isPresent()) {
            System.out.println("є: " + optionalWithValue.get());
        } else {
            System.out.println("нема");
        }
        Optional<String> optionalEmpty = Optional.of(null);

        if (optionalEmpty.isEmpty()) {
            System.out.println("Optional пустий");
        } else {
            System.out.println("Optional не є пустим");
        }
        String value = optionalWithValue.get();
        System.out.println("Значення: " + value);
    }
}
