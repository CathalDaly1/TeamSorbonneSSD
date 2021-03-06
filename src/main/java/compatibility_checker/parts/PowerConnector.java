package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class PowerConnector extends Part implements Cloneable{

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
        System.out.println("Power Connect GetConfig called");
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        return configurationDetails;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}
