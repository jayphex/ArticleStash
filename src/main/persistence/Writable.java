package persistence;

import org.json.JSONObject;
// This interface returns something as a JSON object.

public interface Writable {
    // Code received from the JsonSerializationDemo from the project example provided.
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
