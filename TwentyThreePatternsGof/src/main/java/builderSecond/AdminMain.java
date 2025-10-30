package builderSecond;

public class AdminMain {
    public static void main(String[] args) {
        Admin admin = new Admin.Builder()
                .name("Admin")
                .age(20)
                .surname("Super")
                .password(123456)
                .build();
        System.out.println(admin);
    }
}
