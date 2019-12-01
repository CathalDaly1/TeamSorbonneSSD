package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.ConfigurationDetails;

public class Gpu extends CompositePart {

    private int baseClock;
    private double memoryCapacity;
    private String memoryType;
    private int cudaCores;

    public Gpu(String name, String brand, double wattage, int baseClock, double memoryCapacity, String memoryType, int cudaCores) {
        super(name, brand, wattage);
        this.baseClock = baseClock;
        this.memoryCapacity = memoryCapacity;
        this.memoryType = memoryType;
        this.cudaCores = cudaCores;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(int baseClock) {
        this.baseClock = baseClock;
    }

    public double getMemoryCapacity() {
        return memoryCapacity;
    }

    public void setMemoryCapacity(double memoryCapacity) {
        this.memoryCapacity = memoryCapacity;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getCudaCores() {
        return cudaCores;
    }

    public void setCudaCores(int cudaCores) {
        this.cudaCores = cudaCores;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        super.getConfiguration(configurationDetails);
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        System.out.println("GPU GetConfig called");
        return configurationDetails;
    }
}
