package RestAPIHandlers.Command.GetHandlerCommands;

import auctions.Advert;
import Interceptor.ClientRequestDispatcher;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import  rest_api_handlers.APIHandler;

import static rest_api_handlers.APIHandler.URL_ADDRESS;
public class GetAdvertsByPartTypeCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        List<Advert> adverts = new ArrayList<Advert>();
        String url = URL_ADDRESS + "/advertsByType/?";

        url = apiHandler.addParameterToUrl(url,"partType", (String) parameters.getParameters().get("type"),true);

        JSONObject jsonObject = apiHandler.executeQuery(url);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i = 0;i<jsonArray.length();i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            double price = explrObject.getDouble("price");
            int uid = explrObject.getInt("uid");
            int pid = explrObject.getInt("pid");
            Advert advert = new Advert(price,uid,pid,apiHandler.getPartFactory().getNewPart(explrObject));
            adverts.add(advert);
        }
        return new RestResponse(true,adverts);
    }
}
