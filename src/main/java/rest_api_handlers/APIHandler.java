package rest_api_handlers;

import Interceptor.ClientRequestDispatcher;
import RestAPIHandlers.RestRequest;
import compatibility_checker.factories.AMDPartFactory;
import compatibility_checker.factories.IntelPartFactory;
import compatibility_checker.factories.PartFactory;
import org.json.JSONException;
import org.json.JSONObject;
import users.UserFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class APIHandler {
    private static final Logger LOGGER = Logger.getLogger(DeleteHandler.class.getName());
    private static final String RESULTS = "results";

    URL url;
    HttpURLConnection conn;
    PartFactory partFactory;
    IntelPartFactory intelPartFactory;
    AMDPartFactory amdPartFactory;
    UserFactory userNow;

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
        userNow = new UserFactory();
        partFactory = new PartFactory();
        intelPartFactory = new IntelPartFactory();
        amdPartFactory = new AMDPartFactory();
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

            RestRequest restRequest = createRestRequest(conn);
            restRequest.setURL(urlstring);
            ClientRequestDispatcher.getInstance().dispatchClientRestRequestInterceptor(restRequest);

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

    private RestRequest createRestRequest(HttpURLConnection conn) {
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

            RestRequest restRequest = createRestRequest(conn);
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
            LOGGER.log(Level.SEVERE, "context", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "context", e);
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

            RestRequest restRequest = createRestRequest(conn);
            restRequest.setURL(urlstring);
            ClientRequestDispatcher.getInstance().dispatchClientRestRequestInterceptor(restRequest);

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


    public PartFactory getPartFactory() {
        return partFactory;
    }

}
