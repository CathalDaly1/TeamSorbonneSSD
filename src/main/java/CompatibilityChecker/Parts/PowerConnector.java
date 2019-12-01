package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.ConfigurationDetails;

public class PowerConnector extends Part {

    private int numberOfPins;

    public PowerConnector(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public int getNumberOfPins() {
        return numberOfPins;
    }

    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        return configurationDetails;
    }
}
