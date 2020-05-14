package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class Cooler extends Part {

    public Cooler(String name, String brand, double wattage,String type, double fanSize) {
        super(name,brand,wattage);
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        System.out.println("Cooler GetConfig called");
        return configurationDetails;
    }
}
