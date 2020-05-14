package Interceptor;

public interface RestRequest {
    String getRequestMethod();
    int getResponseCode();
    String getResponseMessage();
    String getURL();
}
