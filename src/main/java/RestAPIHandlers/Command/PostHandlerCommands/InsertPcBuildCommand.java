package RestAPIHandlers.Command.PostHandlerCommands;

import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class InsertPcBuildCommand implements Command {

    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        String url = URL_ADDRESS + "/pc_build/?";

        url = apiHandler.addParameterToUrl(url, "uid", (String) parameters.getParameters().get("uid"), false);
        url = apiHandler.addParameterToUrl(url, "pid", (String) parameters.getParameters().get("pid"), false);
        url = apiHandler.addParameterToUrl(url, "type", (String) parameters.getParameters().get("type"), true);

        if (apiHandler.executeInsert(url)) {
            return new RestResponse(true,null);
        } else {
            return new RestResponse(false,null);
        }
    }
}
