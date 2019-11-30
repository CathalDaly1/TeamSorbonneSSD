package RestAPIHandlers;

import Users.User;
import Users.UserFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PostHandler {

    URL url;
    HttpURLConnection conn;

    private static final String URL_ADDRESS = "http://212.17.39.218:5000";

    public boolean executeInsert(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
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

    public boolean insertUser(User user){
        String url  = URL_ADDRESS + "/user/" + user.getUsername() + "?";

        url = addParameterToUrl(url,"username",user.getUsername(),false);
        url = addParameterToUrl(url,"password",user.getPassword(),false);
        url = addParameterToUrl(url,"email",user.getEmail(),false);
        url = addParameterToUrl(url,"premium",String.valueOf(user.getUserType()),true);

        if(executeInsert(url)){
            return true;
        } else {
            return false;
        }
    }

    public String addParameterToUrl(String url, String parameter, String value,boolean last){
        url += parameter + "=" + value;
        if(!last){
            url += "&";
        }

        return url;
    }


}
