package CompatibilityChecker.Configuration;


public abstract class CompatibilityCheckerDecorator implements ICompatibilityChecker {

    protected ICompatibilityChecker decoratedCompatiblityChecker;
    protected boolean isCompatible = true;

    public CompatibilityCheckerDecorator(ICompatibilityChecker decoratedCompatiblityChecker){
        super();
        this.decoratedCompatiblityChecker = decoratedCompatiblityChecker;
    }

}
