
import Interceptor.ClientRequestDispatcher;
import Interceptor.ClientRequestInterceptor;
import Interceptor.RestRequest;
import ui.controller.HomeScreenController;
import ui.view.HomeScreen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(Main.class.getName());

        HomeScreenController controller = new HomeScreenController();

        ClientRequestInterceptor myInterceptor = new ClientRequestInterceptor(){
            public void onRestRequest(RestRequest context) {
                if (context.getResponseCode() != 200) {
                    LOGGER.log(Level.WARNING, "Rest Request Failure," + context.getRequestMethod() + "," + context.getResponseMessage() + "," + context.getResponseCode()+"," + context.getURL());
                } else{
                    LOGGER.log(Level.INFO, "Rest Request Issued," + context.getRequestMethod() + "," + context.getResponseMessage() + "," + context.getResponseCode()+"," + context.getURL());
                }
            }
        };

        ClientRequestDispatcher.getInstance().registerClientRequestInterceptor(myInterceptor);

        controller.controlStart();
    }
}
