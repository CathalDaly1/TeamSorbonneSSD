package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public class PartFactory {

    private static final String GPU = "GPU";
    private static final String CPU = "CPU";
    private static final String MOTHERBOARD = "Motherboard";
    private static final String RAM = "Ram";
    private static final String COOLER = "Cooler";
    private static final String HARDDRIVE = "Harddrive";
    private static final String POWERSUPPLY = "PowerSupply";

    public Part getNewPart(JSONObject apiResult){
        IntelPartFactory intelPartFactory = new IntelPartFactory();
        AMDPartFactory amdPartFactory = new AMDPartFactory();

        double wattage = (double) apiResult.get("wattage");
        String name = (String) apiResult.get("name");
        String brand = (String) apiResult.get("brand");
        String type = (String) apiResult.get("type");

        JSONObject specificDetails = apiResult.getJSONObject("details");
        CompositePart compositePart;

        if(brand.equals("Intel") && (type.equals(CPU) || type.equals(MOTHERBOARD))){
            compositePart = (CompositePart) intelPartFactory.getNewPart(apiResult);
        }
        else if (brand.equals("AMD")&& (type.equals(CPU) || type.equals(MOTHERBOARD))){
            compositePart = (CompositePart) amdPartFactory.getNewPart(apiResult);
        }
        else if(type.equals(MOTHERBOARD)){
            compositePart = (CompositePart) new Motherboard(name,brand,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.getInt("numberOfRamChannels"),(String)specificDetails.get("ramProtocol"),specificDetails.getInt("fanPins"));
        }
        else if(type.equals(CPU)){
            compositePart = (CompositePart) new Cpu(name, brand, wattage, specificDetails.getString("chipset"), specificDetails.getInt("cores"), specificDetails.getDouble("frequency"));        }
        else if(type.equals(GPU)){
            compositePart = new Gpu(name,brand,wattage,specificDetails.getInt("baseClock"),specificDetails.getDouble("memoryCapacity"),(String)specificDetails.get("memoryType"),specificDetails.getInt("cudaCores"));
        }
        else if(type.equals(RAM)){
            return new Ram(name,brand,wattage,specificDetails.getDouble("dataRate"),specificDetails.getDouble("capacity"),specificDetails.getInt("numberOfChannels"),(String)specificDetails.get("ramProtocol"));
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
            System.out.print("STILL GOT HERE ");
            return null;
        }
        return compositePart;
    }
}
