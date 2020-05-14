package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class Ram extends Part {

    private double dataRate;
    private double capacity;
    private int numberOfChannels;
    private String ramProtocol;

    public Ram(String name, String brand, double wattage, double dataRate, double capacity, int numberOfChannels, String ramProtocol) {
        super(name,brand,wattage);
        this.dataRate = dataRate;
        this.capacity = capacity;
        this.numberOfChannels = numberOfChannels;
        this.ramProtocol = ramProtocol;
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public void setNumberOfChannels(int numberOfChannels) {
        this.numberOfChannels = numberOfChannels;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getDataRate() {
        return dataRate;
    }

    public void setDataRate(double dataRate) {
        this.dataRate = dataRate;
    }

    public String getRamProtocol() {
        return ramProtocol;
    }

    public void setRamProtocol(String ramProtocol) {
        this.ramProtocol = ramProtocol;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        System.out.println("RAM GetConfig called");
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        configurationDetails.addRamType(getRamProtocol());
        configurationDetails.setRamChannels(numberOfChannels);
        return configurationDetails;
    }
}
