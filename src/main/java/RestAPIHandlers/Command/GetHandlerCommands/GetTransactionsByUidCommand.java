package RestAPIHandlers.Command.GetHandlerCommands;

import Auctions.Transaction;
import RestAPIHandlers.APIHandler;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static RestAPIHandlers.APIHandler.URL_ADDRESS;

public class GetTransactionsByUidCommand implements Command {
    @Override
    public RestResponse execute(RestParameters parameters) {
        APIHandler apiHandler = APIHandler.getInstance();

        List<Transaction> transactions = new ArrayList<Transaction>();
        String url = URL_ADDRESS + "/transaction/?";

        url = apiHandler.addParameterToUrl(url,"uid", (String) parameters.getParameters().get("uid"),true);

        JSONObject jsonObject = apiHandler.executeQuery(url);
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i = 0;i<jsonArray.length();i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            int tid = explrObject.getInt("tid");
            double price = explrObject.getDouble("price");
            int sellerId = explrObject.getInt("uid1");
            int buyerId = explrObject.getInt("uid2");
            Transaction transaction = new Transaction(tid,price,sellerId,buyerId);
            transactions.add(transaction);
        }
        return new RestResponse(true,transactions);
    }
}
