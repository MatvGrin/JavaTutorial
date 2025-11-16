package builderThirdRealisation;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.HttpRequestBuilder()
                .method(Methods.POST)
                .url("https://api.example.com/login")
                .addHeader("Content-Type", "application/json")
                .body("{\"user\":\"admin\"}")
                .build();

        System.out.println(request);
    }
}
