package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import  rest_api_handlers.APIHandler;

import static rest_api_handlers.APIHandler.URL_ADDRESS;
public class GetPartNamesWithTypeCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        ArrayList<String> parts = new ArrayList<>();
        JSONObject jsonObject = apiHandler.executeQuery(URL_ADDRESS + "/part/" + parameters.getParameters().get("type"));

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            parts.add((String)explrObject.get("name"));
        }
        RestResponse restResponse = new RestResponse(true,parts);

        return restResponse;
    }
}
