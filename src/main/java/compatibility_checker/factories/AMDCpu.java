package compatibility_checker.factories;

import compatibility_checker.parts.Cpu;

public class AMDCpu extends Cpu {
    public AMDCpu(String name, String brand, double wattage, String chipset, int cores, double frequency) {
        super(name, brand, wattage, chipset, cores, frequency);
    }
}
