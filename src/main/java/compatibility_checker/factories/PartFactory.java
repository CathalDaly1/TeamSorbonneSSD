package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public class PartFactory {

    private static final String GPU = "GPU";
    private static final String CPU = "CPU";
    private static final String RAM = "Ram";
    private static final String MOTHERBOARD = "Motherboard";
    private static final String COOLER = "Cooler";
    private static final String HARDDRIVE = "Harddrive";
    private static final String POWERSUPPLY = "PowerSupply";

    public Part getNewPart(JSONObject apiResult){
        double wattage = (double) apiResult.get("wattage");
        String name = (String) apiResult.get("name");
        String brand = (String) apiResult.get("brand");
        String type = (String) apiResult.get("type");

        JSONObject specificDetails = apiResult.getJSONObject("details");
        CompositePart compositePart;

        if(type.equals(CPU)){
            compositePart = new Cpu(name,brand,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.get("cores"),(double)specificDetails.get("frequency"));
        }
        else if(type.equals(GPU)){
            compositePart = new Gpu(name,brand,wattage,specificDetails.getInt("baseClock"),specificDetails.getDouble("memoryCapacity"),(String)specificDetails.get("memoryType"),specificDetails.getInt("cudaCores"));
        }
        else if(type.equals(RAM)){
            return new Ram(name,brand,wattage,specificDetails.getDouble("dataRate"),specificDetails.getDouble("capacity"),specificDetails.getInt("numberOfChannels"),(String)specificDetails.get("ramProtocol"));
        }
        else if(type.equals(MOTHERBOARD)){
            compositePart = new Motherboard(name,brand,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.getInt("numberOfRamChannels"),(String)specificDetails.get("ramProtocol"),2);
        }
        else if(type.equals(COOLER)){
            return new Cooler(name,brand,wattage,(String)specificDetails.get("type"),specificDetails.getDouble("fanSizemm"));
        }
        else if(type.equals(HARDDRIVE)){
            return new Hardrive(name,brand,wattage,(String)specificDetails.get("type"),specificDetails.getDouble("capactiy"),specificDetails.getDouble("readSpeed"),specificDetails.getDouble("writeSpeed"));
        }
        else if(type.equals(POWERSUPPLY)){
            return new PowerSupply(name,brand,specificDetails.getDouble("wattageOutput"));
        }
        else {
            return null;
        }
        return compositePart;
    }
}
