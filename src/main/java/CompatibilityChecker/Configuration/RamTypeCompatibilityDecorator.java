package CompatibilityChecker.Configuration;

import java.util.List;

public class RamTypeCompatibilityDecorator extends CompatibilityCheckerDecorator {

    ConfigurationDetails configurationDetails;

    public RamTypeCompatibilityDecorator(ICompatibilityChecker compatibilityChecker, ConfigurationDetails configurationDetails){
        super(compatibilityChecker);
        this.configurationDetails = configurationDetails;
    }

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        decoratedCompatiblityChecker.isCompatible(compatibilityResult);
        List<String> ramTypes = configurationDetails.getRamTypes();
        for(int i =0;i < ramTypes.size()-1;i++){
            if(!ramTypes.get(i).equals(ramTypes.get(i+1))){
                compatibilityResult.setCompatible(false);
                compatibilityResult.setMessage(compatibilityResult.getMessage() +"\nThe motherboard ram type does not match the ram you selected");
                return compatibilityResult;
            }
        }
        return compatibilityResult;
    }
}
