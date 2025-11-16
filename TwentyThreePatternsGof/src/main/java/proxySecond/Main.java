package proxySecond;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Image image = new Image();

        ImageProxy imageProxy1 = new ImageProxy("run");
        ImageProxy imageProxy2 = new ImageProxy("display");

        image.display(imageProxy1);
        image.display(imageProxy2);
    }
}
