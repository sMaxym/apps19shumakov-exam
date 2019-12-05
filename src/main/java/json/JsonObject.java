package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    protected List<JsonPair> items;

    public JsonObject(JsonPair... jsonPairs) {
        items = new ArrayList<JsonPair>(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        String data = "";
        for (JsonPair item : items) {
            if (data != "") {
                data += ", ";
            }
            data += "'" + item.key + "': ";
            data += item.value.toJson();
        }
        return "{" + data + "}";
    }

    public void add(JsonPair jsonPair) {
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).key == jsonPair.key) {
                items.set(i, jsonPair);
                return;
            }
        }
        items.add(jsonPair);
    }

    public boolean contains(String name) {
        for (JsonPair item : items) {
            if (item.key == name) {
                return true;
            }
        }
        return false;
    }

    public Json find(String name) {
        for (JsonPair item : items) {
            if (item.key == name) {
                return item.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject filtered = new JsonObject();
        for (JsonPair item : items) {
            for (String name : names) {
                if (item.key == name) {
                    filtered.add(item);
                    break;
                }
            }
        }
        return filtered;
    }
}
