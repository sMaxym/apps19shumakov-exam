package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    private final Boolean val;

    public JsonBoolean(Boolean bool) {
        this.val = bool;
    }

    @Override
    public String toJson() {
        return val.toString();
    }
}
