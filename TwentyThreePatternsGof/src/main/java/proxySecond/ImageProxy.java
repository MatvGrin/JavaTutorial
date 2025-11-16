package proxySecond;

public class ImageProxy{
    private RealImage realImage = new RealImage();
    private String method;

    public ImageProxy(String method) {
        this.method = method;
    }

    void call(){
        if (method.equals("display")){
            realImage.call();
        }else {
            System.out.println("Not correct name of method.");
        }
    }
}
