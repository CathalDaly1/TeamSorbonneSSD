package RestAPIHandlers;

public class RestRequest implements Interceptor.RestRequest {

    private String requestMethod;
    private int responseCode;
    private String responseMessage;
    private String URL;

    public RestRequest(String requestMethod, int responseCode, String responseMessage) {
        this.requestMethod = requestMethod;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    @Override
    public String getRequestMethod() {
        return requestMethod;
    }

    @Override
    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getResponseMessage() {
        return responseMessage;
    }

    @Override
    public String getURL() {
        return null;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
