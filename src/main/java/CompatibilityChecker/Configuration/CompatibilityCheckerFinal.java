package CompatibilityChecker.Configuration;

import CompatibilityChecker.Parts.CompositePart;
import CompatibilityChecker.Parts.IConfigDetails;

public class CompatibilityCheckerFinal implements ICompatibilityCheckerFinal {

    @Override
    public CompatibilityResult getCompatibilityOfParts(IConfigDetails parts) {
            CompatibilityResult compatibilityResult = new CompatibilityResult();
            ConfigurationDetails configurationDetails = parts.getConfiguration(new ConfigurationDetails());

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
