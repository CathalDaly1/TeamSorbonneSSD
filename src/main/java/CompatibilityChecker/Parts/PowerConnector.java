package CompatibilityChecker.Parts;

public class PowerConnector extends Part {

    private int numberOfPins;

    public PowerConnector(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }

    public int getNumberOfPins() {
        return numberOfPins;
    }

    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }
}
