package RestAPIHandlers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteHandler extends APIHandler {

    URL url;
    HttpURLConnection conn;

    private static final String URL_ADDRESS = "http://212.17.39.218:5000";

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
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
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
}

