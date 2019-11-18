package CompatibilityChecker.Parts;

public class Ram extends Equipment {

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
}
