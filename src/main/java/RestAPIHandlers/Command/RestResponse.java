package RestAPIHandlers.Command;

import java.util.List;

public class RestResponse {

    private boolean restReponse;
    private Object valueReturned;

    public RestResponse(boolean restReponse, Object valueReturned) {
        this.restReponse = restReponse;
        this.valueReturned = valueReturned;
    }

    public boolean isRestReponse() {
        return restReponse;
    }

    public void setRestReponse(boolean restReponse) {
        this.restReponse = restReponse;
    }

    public Object getValueReturned() {
        return valueReturned;
    }

    public void setValueReturned(Object valueReturned) {
        this.valueReturned = valueReturned;
    }
}
