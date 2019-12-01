package RestAPIHandlers;

import Users.User;
import Users.UserFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PostHandler extends APIHandler{

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

    public boolean insertPcBuild(String pid,String uid,String type){
        String url = URL_ADDRESS + "/pc_build/?";

        url = addParameterToUrl(url, "uid", uid, false);
        url = addParameterToUrl(url, "pid", pid, false);
        url = addParameterToUrl(url, "type", type, true);

        if (executeInsert(url)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertAdvert(String pid,String uid,String price){

        String url = URL_ADDRESS + "/advert/?";

        url = addParameterToUrl(url, "uid", uid, false);
        url = addParameterToUrl(url, "pid", pid, false);
        url = addParameterToUrl(url, "price", price, true);

        if (executeInsert(url)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertTransaction(String pid,String uid1,String uid2, String price){

        String url = URL_ADDRESS + "/transaction/?";

        url = addParameterToUrl(url, "uid1", uid1, false);
        url = addParameterToUrl(url, "uid2", uid2, false);
        url = addParameterToUrl(url, "pid", pid, false);
        url = addParameterToUrl(url, "price", price, true);

        if (executeInsert(url)) {
            return true;
        } else {
            return false;
        }
    }
}
