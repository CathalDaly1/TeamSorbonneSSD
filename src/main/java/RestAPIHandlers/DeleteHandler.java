package RestAPIHandlers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@Deprecated
public class DeleteHandler extends APIHandler {

    URL url;
    HttpURLConnection conn;

    private static final String URL_ADDRESS = "http://192.168.1.12:5000";

    public boolean deletePcBuild(String uid,String type) {
        String url = URL_ADDRESS + "/pc_build/?";

        url = addParameterToUrl(url, "uid", uid, false);
        url = addParameterToUrl(url, "type", type, true);

        if (executeDelete(url)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAdvert(String uid,String pid){
        String url = URL_ADDRESS + "/advert/?";

        url = addParameterToUrl(url,"uid",uid,false);
        url = addParameterToUrl(url,"pid",pid,true);

        if (executeDelete(url)) {
            return true;
        } else {
            return false;
        }
    }
}

