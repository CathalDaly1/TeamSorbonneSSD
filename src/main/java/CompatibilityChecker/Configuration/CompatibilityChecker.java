package CompatibilityChecker.Configuration;

public class CompatibilityChecker implements  ICompatibilityChecker{

    protected boolean isCompatible = true;

    @Override
    public void isCompatible() {
        System.out.println(isCompatible);
    }
}
