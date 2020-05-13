package CompatibilityChecker.PartFactories;

import CompatibilityChecker.Parts.*;
import org.json.JSONObject;

public interface AbstractPartFactory {

    Part getNewPart(JSONObject apiResult);
    Gpu createGPU(String name, String brand, double wattage, int baseClock, double memoryCapacity, String memoryType, int cudaCores);
    Cpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency);
    Cooler createCooler(String name, String brand, double wattage, String type, double fanSize);
    Motherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins);
    Ram createRam(String name, String brand, double wattage, double dataRate, double capacity, int numberOfChannels, String ramProtocol);
    PowerSupply createPowerSupply(String name, String brand, double wattageOutput);
    Hardrive createHardDrive(String name,String brand, double wattage, String type, double capacity, double readSpeed, double writeSpeed);
}
