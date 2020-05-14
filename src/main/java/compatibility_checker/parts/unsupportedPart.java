package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public abstract class unsupportedPart implements IConfigDetails {

    protected String name;
    protected String brand;
    protected double wattage;

    protected unsupportedPart(String name, String brand, double wattage) {
        this.name = name;
        this.brand = brand;
        this.wattage = wattage;
    }

    protected unsupportedPart(String name) {
        this.name = name;
    }

    public unsupportedPart(){}

    public String getName() {
        return name;
    }

    public int returnZeroWattage() {
        return 0;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ConfigurationDetails getNullConfigDetails(ConfigurationDetails configurationDetails) {
        return configurationDetails;
    }
}
