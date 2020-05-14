package RestAPIHandlers.Command.PostHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class InsertTransactionCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        String url = URL_ADDRESS + "/transaction/?";

        url = apiHandler.addParameterToUrl(url, "uid1", (String) parameters.getParameters().get("uid1"), false);
        url = apiHandler.addParameterToUrl(url, "uid2", (String) parameters.getParameters().get("uid2"), false);
        url = apiHandler.addParameterToUrl(url, "pid", (String) parameters.getParameters().get("pid"), false);
        url = apiHandler.addParameterToUrl(url, "price", (String) parameters.getParameters().get("price"), true);

        if (apiHandler.executeInsert(url)) {
            return new RestResponse(true,null);
        } else {
            return new RestResponse(false,null);
        }
    }
}
