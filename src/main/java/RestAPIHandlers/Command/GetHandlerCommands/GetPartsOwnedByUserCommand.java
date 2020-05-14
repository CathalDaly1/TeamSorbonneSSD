package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetPartsOwnedByUserCommand implements Command {

    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        List<String> pids = new ArrayList<>();
        String url = URL_ADDRESS + "/pc_build/?";

        url = apiHandler.addParameterToUrl(url,"uid", (String) parameters.getParameters().get("uid"),true);

        JSONObject jsonObject = apiHandler.executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            pids.add(String.valueOf(explrObject.get("pid")));
        }

        return  new RestResponse(true,pids);
    }
}
