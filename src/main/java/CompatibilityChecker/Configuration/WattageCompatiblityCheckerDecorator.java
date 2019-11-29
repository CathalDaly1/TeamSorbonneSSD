package CompatibilityChecker.Configuration;

public class WattageCompatiblityCheckerDecorator extends CompatibilityCheckerDecorator {

    private double wattageIn;
    private double wattageOut;

    public WattageCompatiblityCheckerDecorator(ICompatibilityChecker compatibilityChecker, double wattageIn, double wattageOut){
        super(compatibilityChecker);
        this.wattageIn = wattageIn;
        this.wattageOut = wattageOut;
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
