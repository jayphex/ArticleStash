package persistence;

import model.Article;
import model.ArticleStash;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// This class represents a reader that reads article stash from JSON data stored in file.
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads article stash from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ArticleStash read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseArticleStash(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses articlestash from JSON object and returns it
    private ArticleStash parseArticleStash(JSONObject jsonObject) {
        ArticleStash as = new ArticleStash();
        addArticles(as, jsonObject);
        return as;
    }

    // MODIFIES: as
    // EFFECTS: parses articles from JSON object and adds them to article stash
    private void addArticles(ArticleStash as, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("articles");
        for (Object json : jsonArray) {
            JSONObject nextArticle = (JSONObject) json;
            addArticle(as, nextArticle);
        }
    }

    // MODIFIES: as
    // EFFECTS: parses article from JSON object and adds it to ArticleStash
    private void addArticle(ArticleStash as, JSONObject jsonObject) {
        String articleLink = jsonObject.getString("articleLink");
        int articleRating = Integer.parseInt(String.valueOf(jsonObject.getInt("articleRating")));
        String articleComment = jsonObject.getString("articleComment");
        as.addArticle(articleLink, articleRating, articleComment);
    }
}