package RestAPIHandlers.Command;

import java.util.Map;

public class RestParameters {

    private Map<String,Object> parameters;

    public RestParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
