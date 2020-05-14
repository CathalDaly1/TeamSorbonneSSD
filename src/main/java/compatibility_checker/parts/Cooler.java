package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class Cooler extends Part {

    private String type;
    private double fanSizemm;

    public Cooler(String name, String brand, double wattage,String type, double fanSize) {
        super(name,brand,wattage);
        this.type = type;
        this.fanSizemm = fanSize;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        System.out.println("Cooler GetConfig called");
        return configurationDetails;
    }
}
