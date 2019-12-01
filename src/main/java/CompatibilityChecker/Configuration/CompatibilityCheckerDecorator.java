package CompatibilityChecker.Configuration;


public abstract class CompatibilityCheckerDecorator implements ICompatibilityChecker {

    protected ICompatibilityChecker decoratedCompatiblityChecker;
    protected CompatibilityResult compatibilityResult = new CompatibilityResult();

    public CompatibilityCheckerDecorator(ICompatibilityChecker decoratedCompatiblityChecker){
        super();
        this.decoratedCompatiblityChecker = decoratedCompatiblityChecker;
    }

}
