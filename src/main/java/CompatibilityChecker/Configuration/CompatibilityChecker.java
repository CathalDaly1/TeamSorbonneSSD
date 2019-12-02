package CompatibilityChecker.Configuration;

public class CompatibilityChecker implements ICompatibilityChecker{

    protected boolean isCompatible = true;

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        return new CompatibilityResult();
    }


    public CompatibilityResult getCompatibility(ConfigurationDetails configurationDetails){
        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
                new CompatibilityChecker(),configurationDetails);

        SocketCompatibilityCheckerDecorator socketCompatibilityCheckerDecorator = new SocketCompatibilityCheckerDecorator(
                wattageCompatiblityCheckerDecorator,configurationDetails);

        RamTypeCompatibilityDecorator ramTypeCompatibilityDecorator = new RamTypeCompatibilityDecorator(
                socketCompatibilityCheckerDecorator,configurationDetails);

        RamChannelCompatibilityDecorator ramChannelCompatibilityDecorator = new RamChannelCompatibilityDecorator(
                ramTypeCompatibilityDecorator,configurationDetails);

        ICompatibilityChecker compatibilityCheckerFinal = ramChannelCompatibilityDecorator;

        return compatibilityCheckerFinal.isCompatible(new CompatibilityResult());
    }

}
