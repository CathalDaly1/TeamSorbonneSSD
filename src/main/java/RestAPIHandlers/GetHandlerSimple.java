package RestAPIHandlers;


import Users.User;
import Users.UserFactory;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class GetHandlerSimple implements GetAPI {
    
    URL url;
    HttpURLConnection conn;
    UserFactory userFactory;


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
        System.out.print(restResult);

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
        JSONObject jsonObject = executeQuery("http://localhost:5000/user/");

        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            System.out.println(explrObject);
            System.out.println(explrObject.get("username"));
        }

        return users;
    }

    public User getUserWithName(String username){
        JSONObject jsonObject = executeQuery("http://localhost:5000/user/" + username);

        JSONArray jsonArray = jsonObject.getJSONArray("results");
        JSONObject explrObject = jsonArray.getJSONObject(0);
        int id = (int) explrObject.get("uid");
        String email = (String) explrObject.get("email");
        String password = (String) explrObject.get("email");
        int premium = (int) explrObject.get("premium");
        return(userFactory.addNewUser(id,username,password,email,premium));
    }
}
