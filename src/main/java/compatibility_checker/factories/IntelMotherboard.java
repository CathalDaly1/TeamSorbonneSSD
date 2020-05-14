package compatibility_checker.factories;

import compatibility_checker.parts.Motherboard;

public class IntelMotherboard  extends Motherboard {
    public IntelMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        super(name, brand, wattage, chipset, numberOfRamChannels, ramProtocol, fanPins);
    }
}
