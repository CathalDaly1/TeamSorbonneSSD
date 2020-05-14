package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public class IntelPartFactory implements AbstractPartFactory{

    private static final String GPU = "GPU";
    private static final String CPU = "CPU";
    private static final String RAM = "Ram";
    private static final String MOTHERBOARD = "Motherboard";
    private static final String COOLER = "Cooler";
    private static final String HARDDRIVE = "Harddrive";
    private static final String POWERSUPPLY = "PowerSupply";
    private static  final String INTEL = "Intel";
    private CompositePart compositePart;

    @Override
    public Part getNewPart(JSONObject apiResult){
        double wattage = (double) apiResult.get("wattage");
        String name = (String) apiResult.get("name");
        String brand = (String) apiResult.get("brand");
        String type = (String) apiResult.get("type");

        JSONObject specificDetails = apiResult.getJSONObject("details");
        CompositePart compositePart;

        if(type.equals(CPU)){
            return createCPU(name, INTEL, wattage, specificDetails.getString("chipset"), specificDetails.getInt("cores"), specificDetails.getDouble("frequency"));
        }
        else if(type.equals(GPU)){
            return createGPU(name,INTEL,wattage,specificDetails.getInt("baseClock"),specificDetails.getDouble("memoryCapacity"),(String)specificDetails.get("memoryType"),specificDetails.getInt("cudaCores"));
        }
        else if(type.equals(RAM)){
            return createRam(name,INTEL,wattage,specificDetails.getDouble("dataRate"),specificDetails.getDouble("capacity"),specificDetails.getInt("numberOfChannels"),(String)specificDetails.get("ramProtocol"));
        }
        else if(type.equals(MOTHERBOARD)){
            return  createMotherboard(name,INTEL,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.getInt("numberOfRamChannels"),(String)specificDetails.get("ramProtocol"),specificDetails.getInt("fanPins"));
        }
        else if(type.equals(COOLER)){
            return createCooler(name,INTEL,wattage,(String)specificDetails.get("type"),specificDetails.getDouble("fanSizemm"));
        }
        else if(type.equals(HARDDRIVE)){
            return createHardDrive(name,INTEL,wattage,(String)specificDetails.get("type"),specificDetails.getDouble("capactiy"),specificDetails.getDouble("readSpeed"),specificDetails.getDouble("writeSpeed"));
        }
        else if(type.equals(POWERSUPPLY)){
            return createPowerSupply(name,INTEL,specificDetails.getDouble("wattageOutput"));
        }
        else {
            return null;
        }
    }

    @Override
    public Gpu createGPU(String name, String brand, double wattage, int baseClock, double memoryCapacity, String memoryType, int cudaCores) {
        return new Gpu(name,INTEL,wattage,baseClock,memoryCapacity,memoryType,cudaCores);
    }

    @Override
    public Cpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency) {
        return (Cpu) (compositePart = new Cpu(name,INTEL,wattage,chipset,cores,frequency));
    }

    @Override
    public Cooler createCooler(String name, String brand, double wattage, String type, double fanSize) {
        return new Cooler(name,INTEL,wattage,type,fanSize);
    }

    @Override
    public Motherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        return  new Motherboard(name,INTEL,wattage,chipset,numberOfRamChannels,ramProtocol,fanPins);
    }

    @Override
    public Ram createRam(String name, String brand, double wattage, double dataRate, double capacity, int numberOfChannels, String ramProtocol) {
        return  new Ram(name,INTEL,wattage, dataRate,capacity,numberOfChannels,ramProtocol);
    }

    @Override
    public PowerSupply createPowerSupply(String name, String brand, double wattageOutput) {
        return new PowerSupply(name,INTEL,wattageOutput);
    }

    @Override
    public Hardrive createHardDrive(String name, String brand, double wattage, String type, double capacity, double readSpeed, double writeSpeed) {
        return new Hardrive(name,INTEL,wattage,type,capacity,readSpeed,writeSpeed);
    }
}
