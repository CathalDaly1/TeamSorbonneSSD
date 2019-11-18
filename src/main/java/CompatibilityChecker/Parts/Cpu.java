package CompatibilityChecker.Parts;

public class Cpu extends CompositeEquipment {

    private int cores;
    private double frequency;
    private String chipset;

    public Cpu(String name, String brand, double wattage, String chipset, int cores,double frequency){
        super(name, brand, wattage);
        this.chipset = chipset;
        this.cores = cores;
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
}