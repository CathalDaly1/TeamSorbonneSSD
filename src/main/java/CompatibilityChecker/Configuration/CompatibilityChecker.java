package CompatibilityChecker.Configuration;

public class CompatibilityChecker implements  ICompatibilityChecker{

    protected boolean isCompatible = true;

    @Override
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult) {
        return new CompatibilityResult();
    }
}
