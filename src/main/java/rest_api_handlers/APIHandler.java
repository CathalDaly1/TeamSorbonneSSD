package rest_api_handlers;

import compatibility_checker.factories.AMDPartFactory;
import compatibility_checker.factories.IntelPartFactory;
import compatibility_checker.factories.PartFactory;
import compatibility_checker.parts.*;
import org.json.JSONException;
import org.json.JSONObject;
import users.isPremium;

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
    isPremium userNow;

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
        userNow = new isPremium();
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
    public JSONObject executeQuery(String urlstring){
        String restResult = "";

        try {
            url = new URL(urlstring);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

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
