package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class PowerSupply extends CompositePart {

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

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        super.getConfiguration(configurationDetails);
        System.out.println("PSU GetConfig called");
        configurationDetails.setWattageOut(this.wattageOutput);
        return configurationDetails;
    }
}
