package persistence;

import model.ArticleStash;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class represents a writer that writes JSON representation of articlestash to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // Code received from the JsonSerializationDemo from the project example provided.
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    // MODIFIES: this
    // EFFECTS: writes JSON representation of articlestash to file
    public void write(ArticleStash stash) {
        JSONObject json = stash.toJson();
        saveToFile(json.toString(TAB));
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
