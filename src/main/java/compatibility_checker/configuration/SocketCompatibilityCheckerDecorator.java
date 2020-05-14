package compatibility_checker.configuration;

import java.util.List;

public class SocketCompatibilityCheckerDecorator extends CompatibilityCheckerDecorator {

    ConfigurationDetails configurationDetails;

    public SocketCompatibilityCheckerDecorator(ICompatibilityChecker compatibilityChecker, ConfigurationDetails configurationDetails){
        super(compatibilityChecker);
        this.configurationDetails = configurationDetails;
    }

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        decoratedCompatiblityChecker.isCompatible(compatibilityResult);
        List<String> sockets = configurationDetails.getSockets();
        for(int i =0;i < sockets.size()-1;i++){
            if(!sockets.get(i).equals(sockets.get(i+1))){
                compatibilityResult.setCompatible(false);
                compatibilityResult.setMessage(compatibilityResult.getMessage() +"\nThe socket types do not match betweeen the CPU and Motherboard");
                return compatibilityResult;
            }
        }
        return compatibilityResult;
    }
}
