package CompatibilityChecker.Configuration;

import java.util.List;

public class SocketCompatibilityCheckerDecorator extends CompatibilityCheckerDecorator {

    ConfigurationDetails configurationDetails;

    public SocketCompatibilityCheckerDecorator(ICompatibilityChecker compatibilityChecker, ConfigurationDetails configurationDetails){
        super(compatibilityChecker);
        this.configurationDetails = configurationDetails;
    }

    @Override
    public void isCompatible() {
        decoratedCompatiblityChecker.isCompatible();
        List<String> sockets = configurationDetails.getSockets();
        for(int i =0;i < sockets.size();i++){
            if(sockets.get(i+1) != null){
                if(!sockets.get(i).equals(sockets.get(i+1))){
                    isCompatible = false;
                }
            }
        }
        System.out.println(isCompatible);
    }
}
