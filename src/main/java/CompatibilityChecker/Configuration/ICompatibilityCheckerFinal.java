package CompatibilityChecker.Configuration;

import CompatibilityChecker.Parts.CompositePart;
import CompatibilityChecker.Parts.IConfigDetails;

public interface ICompatibilityCheckerFinal {

    public CompatibilityResult getCompatibilityOfParts(IConfigDetails configDetails);

}
