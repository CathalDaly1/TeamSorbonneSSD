package Interceptor;

import org.omg.PortableInterceptor.Interceptor;

import java.util.ArrayList;

public class ClientRequestDispatcher {
    ArrayList<ClientRequestInterceptor> interceptors = new ArrayList<>();

    static ClientRequestDispatcher singleInstance = null;

    public static ClientRequestDispatcher getInstance(){
        if(singleInstance == null){
            singleInstance = new ClientRequestDispatcher();
        }

        return singleInstance;
    }


    public void registerClientRequestInterceptor(ClientRequestInterceptor interceptor){
        interceptors.add(interceptor);
    }

    public void removeClientRequestInterceptor(ClientRequestInterceptor interceptor){
        interceptors.remove(interceptor);
    }

    public void dispatchClientRestRequestInterceptor(RestRequest context){
        for(int i =0;i<interceptors.size();i++){
            ClientRequestInterceptor ic = (ClientRequestInterceptor)interceptors.get(i);
            ic.onRestRequest(context);
        }
    }
}
