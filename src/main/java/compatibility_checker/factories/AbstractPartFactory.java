package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public interface AbstractPartFactory {
    Part getNewPart(JSONObject apiResult);
    Cpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency);
    Motherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins);
}



