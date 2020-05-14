package compatibility_checker.factories;

import compatibility_checker.parts.Motherboard;

public class AMDMotherboard extends Motherboard {
    public AMDMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        super(name, brand, wattage, chipset, numberOfRamChannels, ramProtocol, fanPins);
    }
}
