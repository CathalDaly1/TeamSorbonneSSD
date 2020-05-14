package rest_api_handlers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DeleteHandler extends APIHandler {

    URL url;
    HttpURLConnection conn;
    private static final Logger LOGGER = Logger.getLogger(DeleteHandler.class.getName());


    public boolean executeDelete(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.connect();

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("HttpResponseCode" + conn.getResponseCode());
            }
            else {
                return true;
            }
        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, "context", e);
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "context", e);
            return false;
        }
    }

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

