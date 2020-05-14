package compatibility_checker.cache;

import compatibility_checker.parts.Part;

import java.util.Hashtable;

public class partsCache {
    private static Hashtable<String, Part> partMap = new Hashtable<String, Part>();


    public static Part getPart(String partName) {
        Part cachedPart = partMap.get(partName);
        return (Part) ((Part)cachedPart).clone();
    }

    public static void loadCache() {
        Part twoPinPowerConnector = new TwoPinPowerConnector();
        partMap.put("2", twoPinPowerConnector);

        Part fourPinPowerConnector = new FourPinPowerConnector();
        partMap.put("4", fourPinPowerConnector);

        Part sixPinPowerConnector = new SixPinPowerConnector();
        partMap.put("6", sixPinPowerConnector);

        Part eightPinPowerConnector = new EightPinPowerConnector();
        partMap.put("8", eightPinPowerConnector);
    }
}
