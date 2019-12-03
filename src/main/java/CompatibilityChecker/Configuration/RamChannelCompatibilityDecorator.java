package CompatibilityChecker.Configuration;

import java.util.List;

public class RamChannelCompatibilityDecorator extends CompatibilityCheckerDecorator {

    ConfigurationDetails configurationDetails;

    public RamChannelCompatibilityDecorator(ICompatibilityChecker compatibilityChecker, ConfigurationDetails configurationDetails){
        super(compatibilityChecker);
        this.configurationDetails = configurationDetails;
    }

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        decoratedCompatiblityChecker.isCompatible(compatibilityResult);
        int motherboardRamChannels = configurationDetails.getMotherboardRamChannels() ;
        int ramChannels = configurationDetails.getRamChannels();
        if(motherboardRamChannels<ramChannels){
            compatibilityResult.setCompatible(false);
            compatibilityResult.setMessage(compatibilityResult.getMessage() +"\nThe motherboard does not have enough ram channels!");
            return compatibilityResult;
        }
        return compatibilityResult;
    }
}
