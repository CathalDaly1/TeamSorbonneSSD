package compatibility_checker.factories;

import compatibility_checker.parts.*;
import org.json.JSONObject;

public class IntelPartFactory implements AbstractPartFactory{

    private static final String GPU = "GPU";
    private static final String CPU = "CPU";
    private static final String MOTHERBOARD = "Motherboard";
    private static  final String INTEL = "Intel";

    @Override
    public Part getNewPart(JSONObject apiResult){
        double wattage = (double) apiResult.get("wattage");
        String name = (String) apiResult.get("name");
        String type = (String) apiResult.get("type");

        JSONObject specificDetails = apiResult.getJSONObject("details");

        if(type.equals(CPU)){
            return createCPU(name, INTEL, wattage, specificDetails.getString("chipset"), specificDetails.getInt("cores"), specificDetails.getDouble("frequency"));
        }
        else if(type.equals(MOTHERBOARD)){
            return  createMotherboard(name,INTEL,wattage,(String)specificDetails.get("chipset"),(int)specificDetails.getInt("numberOfRamChannels"),(String)specificDetails.get("ramProtocol"),specificDetails.getInt("fanPins"));
        }

        else {
            System.out.println("part factory fail");
            return null;
        }
    }


    @Override
    public IntelCpu createCPU(String name, String brand, double wattage, String chipset, int cores, double frequency) {
        return new IntelCpu(name,INTEL,wattage,chipset,cores,frequency);
    }

    @Override
    public IntelMotherboard createMotherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        return  new IntelMotherboard(name,INTEL,wattage,chipset,numberOfRamChannels,ramProtocol,fanPins);
    }

}
