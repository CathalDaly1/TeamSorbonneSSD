package RestAPIHandlers;


import CompatibilityChecker.Parts.Part;
import Users.User;
import Users.UserFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetHandler extends APIHandler implements GetAPI {
    
    URL url;
    HttpURLConnection conn;
    UserFactory userFactory;

    private static final String URL_ADDRESS = "http://212.17.39.218:5000";

    public GetHandler(){
        userFactory = new UserFactory();
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
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return(createJsonObject(restResult));
    }

    private JSONObject createJsonObject(String restResult) {

        restResult = restResult.replace("\\\"","\"");
        restResult = restResult.substring(1,restResult.length()-1);
//        System.out.print(restResult);

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

        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
        }

        return users;
    }

    public User getUserWithName(String username){
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/user/" + username);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            System.out.println(explrObject);
            int id = (int) explrObject.get("uid");
            String email = (String) explrObject.get("email");
            String password = (String) explrObject.get("password");
            boolean premium = (boolean) explrObject.get("premium");
            return (userFactory.addNewUser(id, username, email, password, premium));
        }
        else {
            return null;
        }
    }

    public List<String> getPartNamesWithType(String type){
        ArrayList<String> parts = new ArrayList<>();
        JSONObject jsonObject = executeQuery(URL_ADDRESS + "/part/" + type);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

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
            e.printStackTrace();
        }

        String url  = URL_ADDRESS + "/partId/?";

        url = addParameterToUrl(url,"partName",name,true);

        JSONObject jsonObject = executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

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

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            parts.add((String)explrObject.get("name"));
        }

        return parts;
    }

}
