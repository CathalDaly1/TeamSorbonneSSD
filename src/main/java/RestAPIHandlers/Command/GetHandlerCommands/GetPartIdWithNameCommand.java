package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetPartIdWithNameCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        String name = String.valueOf(parameters.getParameters().get("name"));
        try {
            name = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url  = URL_ADDRESS + "/partId/?";

        url = apiHandler.addParameterToUrl(url,"partName",name,true);

        JSONObject jsonObject = apiHandler.executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray("results");


        Object valueReturned;
        if(jsonArray.length() > 0) {
            JSONObject explrObject = jsonArray.getJSONObject(0);
            String id = String.valueOf(explrObject.get("pid"));
            valueReturned = id;
        }
        else {
            valueReturned = null;
        }

        RestResponse restResponse = new RestResponse(true,valueReturned);

        return restResponse;
    }
}
