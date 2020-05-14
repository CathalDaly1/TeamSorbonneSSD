package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public class AMDPartFactory implements AbstractPartFactory{

    private static final String GPU = "GPU";
    private static final String CPU = "CPU";
    private static final String MOTHERBOARD = "Motherboard";
    private static final String AMD = "AMD";

    @Override
    public Part getNewPart(JSONObject apiResult){
        double wattage = (double) apiResult.get("wattage");
        String name = (String) apiResult.get("name");
        String type = (String) apiResult.get("type");

        JSONObject specificDetails = apiResult.getJSONObject("details");

        if(type.equals(CPU)){
            return createCPU(name, AMD, wattage, specificDetails.getString("chipset"), specificDetails.getInt("cores"), specificDetails.getDouble("frequency"));
        }
        else if(type.equals(GPU)){
            return createGPU(name,AMD,wattage,specificDetails.getInt("baseClock"),specificDetails.getDouble("memoryCapacity"),(String)specificDetails.get("memoryType"),specificDetails.getInt("cudaCores"));
        }
        else if(type.equals(MOTHERBOARD)){
            return  createMotherboard(name,AMD,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.getInt("numberOfRamChannels"),(String)specificDetails.get("ramProtocol"),specificDetails.getInt("fanPins"));
        }
        else {
            return null;
        }
    }

    @Override
    public Gpu createGPU(String name, String brand, double wattage, int baseClock, double memoryCapacity, String memoryType, int cudaCores) {
        return new Gpu(name,AMD,wattage,baseClock,memoryCapacity,memoryType,cudaCores);
    }

    @Override
    public AMDCpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency) {
        return new AMDCpu(name,AMD,wattage,chipset,cores,frequency);
    }

    @Override
    public AMDMotherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        return  new AMDMotherboard(name,AMD,wattage,chipset,numberOfRamChannels,ramProtocol,fanPins);
    }

}
