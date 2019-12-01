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
    public void isCompatible() {
        decoratedCompatiblityChecker.isCompatible();
        if((wattageOut - wattageIn) < 0){
            this.isCompatible = false;
        }
        System.out.println(isCompatible);
    }
}
