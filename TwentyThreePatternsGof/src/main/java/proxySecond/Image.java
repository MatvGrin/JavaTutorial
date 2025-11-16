package proxySecond;

public class Image{
    public void display(ImageProxy imageProxy) throws InterruptedException {
        System.out.println("You need wait 4 seconds your file downloading.");
        Thread.sleep(4000);
        imageProxy.call();
    }
}
