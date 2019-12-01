package RestAPIHandlers;

public abstract class APIHandler {

    public String addParameterToUrl(String url, String parameter, String value,boolean last){
        url += parameter + "=" + value;
        if(!last){
            url += "&";
        }

        return url;
    }

}
