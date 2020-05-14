package RestAPIHandlers.Command.GetHandlerCommands;

import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import  rest_api_handlers.APIHandler;

import static rest_api_handlers.APIHandler.URL_ADDRESS;
public class GetPartDetailsWithIdCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        String url = URL_ADDRESS + "/partDetails/?";
        APIHandler apiHandler = APIHandler.getInstance();

        url = apiHandler.addParameterToUrl(url,"pid", (String) parameters.getParameters().get("id"),true);

        JSONObject jsonObject = apiHandler.executeQuery(url);

        JSONArray jsonArray = jsonObject.getJSONArray("results");

        JSONObject explrObject = jsonArray.getJSONObject(0);

        System.out.println(explrObject);
        return new RestResponse(true,apiHandler.getPartFactory().getNewPart(explrObject));
    }
}
