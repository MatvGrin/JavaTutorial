package builderThirdRealisation;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class HttpRequest {
    private final Methods method;
    private final String url;
    private final Map<String, String> headers;
    private final String body;

    private HttpRequest(HttpRequestBuilder httpRequestBuilder) {
        this.method = httpRequestBuilder.method;
        this.url = httpRequestBuilder.url;
        this.headers = httpRequestBuilder.headers;
        this.body = httpRequestBuilder.body;
    }

    public Methods getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static class HttpRequestBuilder{
        private Methods method;
        private String url;
        private Map<String, String> headers = new HashMap<>();
        private String body;

        public HttpRequestBuilder() {
        }

        public HttpRequestBuilder method(Methods method){
            this.method = method;
            return this;
        }

        public HttpRequestBuilder url(String url){
            this.url = url;
            return this;
        }

        public HttpRequestBuilder addHeader(String firstValue, String secondValue){
            headers.put(firstValue, secondValue);
            return this;
        }

        public HttpRequestBuilder body(String body){
            this.body = body;
            return this;
        }

        public HttpRequest build(){
            return new HttpRequest(this);
        }
    }
}
