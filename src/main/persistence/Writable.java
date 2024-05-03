package persistence;

import org.json.JSONObject;
// This interface returns something as a JSON object.

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
