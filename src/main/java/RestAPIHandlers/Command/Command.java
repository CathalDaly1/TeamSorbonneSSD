package RestAPIHandlers.Command;

import java.util.List;

public interface Command {
    public RestResponse execute(RestParameters parameters);
}
