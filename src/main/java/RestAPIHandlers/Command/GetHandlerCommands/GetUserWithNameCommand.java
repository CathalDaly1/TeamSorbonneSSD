package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetUserWithNameCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();
        JSONObject jsonObject = apiHandler.executeQuery(URL_ADDRESS + "/user/" + parameters.getParameters().get("username"));

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            System.out.println(explrObject);
            int id = (int) explrObject.get("uid");
            String email = (String) explrObject.get("email");
            String password = (String) explrObject.get("password");
            boolean premium = (boolean) explrObject.get("premium");

            Object valueReturned = (apiHandler.getUserFactory().addNewUser(id, String.valueOf(parameters.getParameters().get("username")), email, password, premium));
            RestResponse restResponse = new RestResponse(true,valueReturned);

            return restResponse;
        }
        else {
            return null;
        }
    }
}