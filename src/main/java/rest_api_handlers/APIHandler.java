package rest_api_handlers;

public abstract class APIHandler {
    public static final String URL_ADDRESS = "http://192.168.1.7:5000";
    public String addParameterToUrl(String url, String parameter, String value,boolean last){
        url += parameter + "=" + value;
        if(!last){
            url += "&";
        }

        return url;
    }

}
