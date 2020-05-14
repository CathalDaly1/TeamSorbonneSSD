package RestAPIHandlers;

import CompatibilityChecker.Parts.PartFactory;
import Interceptor.ClientRequestDispatcher;
import RestAPIHandlers.Command.CommandQueue;
import Users.UserFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class APIHandler {
    URL url;
    HttpURLConnection conn;
    UserFactory userFactory;
    PartFactory partFactory;

    public static final String URL_ADDRESS = "http://192.168.1.12:5000";
    static APIHandler singleInstance = null;

    /**
     * Singleton approach so only one queue
     * @return
     */
    public static APIHandler getInstance(){
        if(singleInstance == null){
            singleInstance = new APIHandler();
        }

        return singleInstance;
    }

    public APIHandler() {
        userFactory = new UserFactory();
        partFactory = new PartFactory();
    }

    public String addParameterToUrl(String url, String parameter, String value,boolean last){
        url += parameter + "=" + value;
        if(!last){
            url += "&";
        }

        return url;
    }

    public boolean executeInsert(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.connect();

            RestRequest restRequest = createRestRequestObject(conn);
            restRequest.setURL(urlstring);
            ClientRequestDispatcher.getInstance().dispatchClientRestRequestInterceptor(restRequest);

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

    private RestRequest createRestRequestObject(HttpURLConnection conn) {

        try {
            return new RestRequest(conn.getRequestMethod(),conn.getResponseCode(),conn.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JSONObject executeQuery(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            RestRequest restRequest = createRestRequestObject(conn);
            restRequest.setURL(urlstring);
            ClientRequestDispatcher.getInstance().dispatchClientRestRequestInterceptor(restRequest);

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("HttpResponseCode" + conn.getResponseCode());
            }
            else{
                Scanner sc = new Scanner(url.openStream());
                while(sc.hasNext()){
                    restResult+=sc.nextLine();
                }
                sc.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(createJsonObject(restResult));
    }

    private JSONObject createJsonObject(String restResult) {

        restResult = restResult.replace("\\\"","\"");
        restResult = restResult.substring(1,restResult.length()-1);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject(restResult);
        }catch (JSONException err){
            System.out.println(err);
        }
        return jsonObject;
    }


    public boolean executeDelete(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.connect();

            RestRequest restRequest = createRestRequestObject(conn);
            restRequest.setURL(urlstring);
            ClientRequestDispatcher.getInstance().dispatchClientRestRequestInterceptor(restRequest);

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

    public UserFactory getUserFactory(){
        return userFactory;
    }

    public PartFactory getPartFactory(){
        return partFactory;
    }
}
