package adapterSecond;

import java.util.Scanner;

public class ATS {
    Scanner scanner = new Scanner(System.in);
    void handle(PaymentProcessor processor){
        System.out.print("Input amount in USD: ");
        double v = scanner.nextDouble();
        processor.pay(v);
    }

}
