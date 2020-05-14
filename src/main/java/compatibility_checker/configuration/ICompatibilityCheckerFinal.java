package compatibility_checker.configuration;

import compatibility_checker.parts.IConfigDetails;

public interface ICompatibilityCheckerFinal {

    public CompatibilityResult getCompatibilityOfParts(IConfigDetails configDetails);

}
