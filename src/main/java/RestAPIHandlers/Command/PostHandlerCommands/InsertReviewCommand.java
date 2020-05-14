package RestAPIHandlers.Command.PostHandlerCommands;

import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import  rest_api_handlers.APIHandler;

import static rest_api_handlers.APIHandler.URL_ADDRESS;
public class InsertReviewCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        String url = URL_ADDRESS + "/review/?";

        url = apiHandler.addParameterToUrl(url, "tid", (String) parameters.getParameters().get("tid"), false);
        url = apiHandler.addParameterToUrl(url, "rating", (String) parameters.getParameters().get("rating"), false);
        url = apiHandler.addParameterToUrl(url, "buyerComment", (String) parameters.getParameters().get("buyerComment"), true);

        if (apiHandler.executeInsert(url)) {
            return new RestResponse(true,null);
        } else {
            return new RestResponse(false,null);
        }
    }
}
