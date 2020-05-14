package RestAPIHandlers.Command.GetHandlerCommands;

import rest_api_handlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import users.User;
import org.json.JSONArray;
import org.json.JSONObject;
import users.isPremium;

import static rest_api_handlers.APIHandler.URL_ADDRESS;

public class GetUsersByIdCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();
        isPremium userNow = new isPremium();

        String url = URL_ADDRESS + "/userById/?";

        url = apiHandler.addParameterToUrl(url,"uid", (String) parameters.getParameters().get("uid"),true);

        JSONObject jsonObject = apiHandler.executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray("results");
        User user;
        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            String username  = explrObject.getString("username");
            String email = (String) explrObject.get("email");
            String password = (String) explrObject.get("password");
            boolean premium = (boolean) explrObject.get("premium");
            user = userNow.addNewUser(Integer.parseInt((String) parameters.getParameters().get("uid")), username, email, password, premium);

        }
        else {
            user = null;
        }

        return new RestResponse(true,user);
    }
}
