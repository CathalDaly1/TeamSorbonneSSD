package CompatibilityChecker.Configuration;

public class WattageCompatiblityCheckerDecorator extends CompatibilityCheckerDecorator {

    private double wattageIn;
    private double wattageOut;

    public WattageCompatiblityCheckerDecorator(ICompatibilityChecker compatibilityChecker, ConfigurationDetails configurationDetails){
        super(compatibilityChecker);

        this.wattageIn = configurationDetails.getWattageIn();
        this.wattageOut = configurationDetails.getWattageOut();
    }

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        decoratedCompatiblityChecker.isCompatible(compatibilityResult);
        System.out.println("Wattage in: "+ wattageIn + "\nWattage Out: " + wattageOut);
        if((wattageOut - wattageIn) < 0){
            compatibilityResult.setCompatible(false);
            compatibilityResult.setMessage(compatibilityResult.getMessage() +"\nThe wattage from the power supply is too low for the parts");
            return compatibilityResult;
        }
        return compatibilityResult;
    }
}
