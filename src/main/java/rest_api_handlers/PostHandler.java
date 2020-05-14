package rest_api_handlers;

import users.User;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostHandler extends APIHandler{
    private static final Logger LOGGER = Logger.getLogger(DeleteHandler.class.getName());
    URL url;
    HttpURLConnection conn;


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
            LOGGER.log(Level.SEVERE, "context", e);
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "context", e);
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

    public boolean insertReview(String tid,String rating,String buyerComment){

        String url = URL_ADDRESS + "/review/?";

        try {
            buyerComment = URLEncoder.encode(buyerComment, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "context", e);
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
