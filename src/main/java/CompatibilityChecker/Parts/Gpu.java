package CompatibilityChecker.Parts;

public class Gpu extends CompositeEquipment {

    private double baseClock;
    private double memoryCapacity;
    private String memoryType;
    private int cudaCores;

    public Gpu(String name, String brand, double wattage, double baseClock, double memoryCapacity, String memoryType, int cudaCores) {
        super(name, brand, wattage);
        this.baseClock = baseClock;
        this.memoryCapacity = memoryCapacity;
        this.memoryType = memoryType;
        this.cudaCores = cudaCores;
    }

    public double getBaseClock() {
        return baseClock;
    }

    public void setBaseClock(double baseClock) {
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
}
