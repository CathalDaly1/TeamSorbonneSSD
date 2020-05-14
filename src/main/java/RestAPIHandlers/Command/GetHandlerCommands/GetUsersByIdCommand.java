package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import Users.User;
import org.json.JSONArray;
import org.json.JSONObject;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetUsersByIdCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

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
            user = apiHandler.getUserFactory().addNewUser(Integer.parseInt((String) parameters.getParameters().get("uid")), username, email, password, premium);
        }
        else {
            user = null;
        }

        return new RestResponse(true,user);
    }
}
