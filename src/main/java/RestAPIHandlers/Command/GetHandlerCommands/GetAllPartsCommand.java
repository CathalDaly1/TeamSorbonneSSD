package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetAllPartsCommand implements Command {

    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        ArrayList<String> parts = new ArrayList<>();
        JSONObject jsonObject = apiHandler.executeQuery(URL_ADDRESS + "/parts/");

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            parts.add((String)explrObject.get("name"));
        }

        RestResponse restResponse = new RestResponse(true,parts);
        return restResponse;
    }
}
