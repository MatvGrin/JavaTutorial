package builder;

public class PetMain {
    public static void main(String[] args) {
        Pet pet = new Pet.Builder()
                .alias("Bobik")
                .age(2)
                .color("grey")
                .build();
        System.out.println(pet);

    }
}