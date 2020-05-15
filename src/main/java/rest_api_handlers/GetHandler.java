package rest_api_handlers;


import auctions.Advert;
import auctions.Transaction;
import compatibility_checker.factories.AMDPartFactory;
import compatibility_checker.factories.IntelPartFactory;
import compatibility_checker.factories.PartFactory;
import compatibility_checker.parts.*;
import users.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import users.UserFactory;

import java.util.logging.Level;
import java.util.logging.Logger;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Deprecated
public class GetHandler extends APIHandler implements GetAPI {
    private static final Logger LOGGER = Logger.getLogger(DeleteHandler.class.getName());
    private static final String RESULTS = "results";
    URL url;
    HttpURLConnection conn;
    PartFactory partFactory;

    private static final String URL_ADDRESS = "http://192.168.1.12:5000";
    IntelPartFactory intelPartFactory;
    AMDPartFactory amdPartFactory;
    UserFactory userNow;

    public GetHandler(){
        userNow = new UserFactory();
        partFactory = new PartFactory();
        intelPartFactory = new IntelPartFactory();
        amdPartFactory = new AMDPartFactory();
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

    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/user/");

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
        }

        return users;
    }

    public User getUserWithName(String username){
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/user/" + username);

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            System.out.println(explrObject);
            int id = (int) explrObject.get("uid");
            String email = (String) explrObject.get("email");
            String password = (String) explrObject.get("password");
            boolean premium = (boolean) explrObject.get("premium");
            return (userNow.addNewUser(id, username, email, password, premium));
        }
        else {
            return null;
        }
    }

    public List<String> getPartNamesWithType(String type){
        ArrayList<String> parts = new ArrayList<>();
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/part/" + type);

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            parts.add((String)explrObject.get("name"));
        }

        return parts;
    }

    public String getPartIdWithName(String name){
        try {
            name = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "context", e);
        }

        String url  = URL_ADDRESS + "/partId/?";

        url = addParameterToUrl(url,"partName",name,true);

        JSONObject jsonObject = executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            String id = String.valueOf(explrObject.get("pid"));
            return id;
        }
        else {
            return null;
        }
    }

    public List<String> getAllParts( ){
        ArrayList<String> parts = new ArrayList<>();
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/parts/");

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            parts.add((String)explrObject.get("name"));
        }

        return parts;
    }

    public List<String> getPartsOwnedByUser(String uid){
        List<String> pids = new ArrayList<>();
        String url = URL_ADDRESS + "/pc_build/?";

        url = addParameterToUrl(url,"uid",uid,true);

        JSONObject jsonObject = executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            pids.add(String.valueOf(explrObject.get("pid")));
        }

        return pids;
    }

    public Part getPartDetailsWithId(String id){
        String url = URL_ADDRESS + "/partDetails/?";

        url = addParameterToUrl(url,"pid",id,true);
        JSONObject jsonObject = executeQuery(url);
        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);
        JSONObject explrObject = jsonArray.getJSONObject(0);

        return partFactory.getNewPart(explrObject);
    }

    public List<Advert> getAdvertByPartType(String type){
        List<Advert> adverts = new ArrayList<Advert>();
        String url = URL_ADDRESS + "/advertsByType/?";

        url = addParameterToUrl(url,"partType",type,true);

        JSONObject jsonObject = executeQuery(url);
        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        for(int i = 0;i<jsonArray.length();i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            double price = explrObject.getDouble("price");
            int uid = explrObject.getInt("uid");
            int pid = explrObject.getInt("pid");
            Advert advert = new Advert(price,uid,pid,partFactory.getNewPart(explrObject));
            adverts.add(advert);
        }

        return adverts;
    }

    public List<Transaction> getTransactionsByUid(String uid){
        List<Transaction> transactions = new ArrayList<Transaction>();
        String url = URL_ADDRESS + "/transaction/?";

        url = addParameterToUrl(url,"uid",uid,true);

        JSONObject jsonObject = executeQuery(url);
        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        for(int i = 0;i<jsonArray.length();i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            int tid = explrObject.getInt("tid");
            double price = explrObject.getDouble("price");
            int sellerId = explrObject.getInt("uid1");
            int buyerId = explrObject.getInt("uid2");
            Transaction transaction = new Transaction(tid,price,sellerId,buyerId);
            transactions.add(transaction);
        }

        return transactions;
    }

    public User getUserById(String uid){
        String url = URL_ADDRESS + "/userById/?";

        url = addParameterToUrl(url,"uid",uid,true);

        JSONObject jsonObject = executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray(RESULTS);

        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            String username  = explrObject.getString("username");
            String email = (String) explrObject.get("email");
            String password = (String) explrObject.get("password");
            boolean premium = (boolean) explrObject.get("premium");
            return (userNow.addNewUser(Integer.parseInt(uid), username, email, password, premium));
        }
        else {
            return null;
        }
    }
}
