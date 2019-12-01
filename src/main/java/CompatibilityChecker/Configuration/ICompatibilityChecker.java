package CompatibilityChecker.Configuration;


import CompatibilityChecker.Parts.CompositePart;

public interface ICompatibilityChecker {
    public CompatibilityResult isCompatible(CompatibilityResult compatibilityResult);
}
