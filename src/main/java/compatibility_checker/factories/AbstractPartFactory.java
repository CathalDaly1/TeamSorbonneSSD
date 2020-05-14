package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public interface AbstractPartFactory {

    Part getNewPart(JSONObject apiResult);
    Gpu createGPU(String name, String brand, double wattage, int baseClock, double memoryCapacity, String memoryType, int cudaCores);
    Cpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency);
    Motherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins);
}
