package CompatibilityChecker.Configuration;

import CompatibilityChecker.Parts.CompositePart;

public class CompatibilityCheckerFinal implements ICompatibilityCheckerFinal {

    @Override
    public CompatibilityResult getCompatibilityOfPc(CompositePart pc){
        CompatibilityResult compatibilityResult = new CompatibilityResult();
        ConfigurationDetails configurationDetails = pc.getConfiguration(new ConfigurationDetails());

        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
                new CompatibilityChecker(),configurationDetails);

        SocketCompatibilityCheckerDecorator socketCompatibilityCheckerDecorator = new SocketCompatibilityCheckerDecorator(
                wattageCompatiblityCheckerDecorator,configurationDetails);

        RamTypeCompatibilityDecorator ramTypeCompatibilityDecorator = new RamTypeCompatibilityDecorator(
                socketCompatibilityCheckerDecorator,configurationDetails);

        RamChannelCompatibilityDecorator ramChannelCompatibilityDecorator = new RamChannelCompatibilityDecorator(
                ramTypeCompatibilityDecorator,configurationDetails);

        ICompatibilityChecker compatibilityCheckerFinal = ramChannelCompatibilityDecorator;


        return(compatibilityCheckerFinal.isCompatible(compatibilityResult));
    }
}
