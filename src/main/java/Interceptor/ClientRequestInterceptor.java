package Interceptor;

public interface ClientRequestInterceptor {
    public void onRestRequest(RestRequest context);
}
