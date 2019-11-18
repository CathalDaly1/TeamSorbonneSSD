package CompatibilityChecker.Parts;

public class PowerSupply extends CompositeEquipment {

    private double wattageOutput;

    public PowerSupply(String name, String brand, double wattageOutput) {
        super(name, brand, 0.0);
        this.wattageOutput = wattageOutput;
    }

    public double getWattageOutput() {
        return wattageOutput;
    }

    public void setWattageOutput(double wattageOutput) {
        this.wattageOutput = wattageOutput;
    }
}