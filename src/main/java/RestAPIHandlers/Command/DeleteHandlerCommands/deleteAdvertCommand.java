package RestAPIHandlers.Command.DeleteHandlerCommands;

import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;

import  rest_api_handlers.APIHandler;

import static rest_api_handlers.APIHandler.URL_ADDRESS;
public class deleteAdvertCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        String url = URL_ADDRESS + "/advert/?";

        url = apiHandler.addParameterToUrl(url, "uid", (String) parameters.getParameters().get("uid"), false);
        url = apiHandler.addParameterToUrl(url, "pid", (String) parameters.getParameters().get("pid"), true);

        if (apiHandler.executeDelete(url)) {
            return new RestResponse(true,null);
        } else {
            return new RestResponse(false,null);
        }
    }
}
