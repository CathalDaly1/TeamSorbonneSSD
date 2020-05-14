package RestAPIHandlers;

import Users.User;
import Users.UserFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
@Deprecated
public class PostHandler extends APIHandler{

    URL url;
    HttpURLConnection conn;

    private static final String URL_ADDRESS = "http://192.168.1.12:5000";

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

    public boolean insertReview(String tid,String rating,String buyerComment){

        String url = URL_ADDRESS + "/review/?";

        try {
            buyerComment = URLEncoder.encode(buyerComment, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        url = addParameterToUrl(url, "tid", tid, false);
        url = addParameterToUrl(url, "rating", rating, false);
        url = addParameterToUrl(url, "buyerComment", buyerComment, true);

        if (executeInsert(url)) {
            return true;
        } else {
            return false;
        }
    }
}
