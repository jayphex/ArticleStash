package persistence;

import model.Article;
import model.ArticleStash;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// This class represents a JsonReader test. It tests a non-existent file,
// an empty ArticleStash as well as an ArticleStash of 2 articles.
public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ArticleStash as = new ArticleStash();
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // This should happen
        }
    }

    @Test
    void testReaderEmptyArticleStash() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyArticleStash.json");
        try {
            ArticleStash as = reader.read();
            assertEquals(0, as.getNumOfArticles());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralArticleStash() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralArticleStash.json");
        try {
            ArticleStash as = reader.read();
            List<Article> articles = as.getArticles();
            assertEquals(2, articles.size());
            checkArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi", 5, "Love it!", articles.get(0));
            checkArticle("https://www.theguardian.com/football/2024/feb/16/arsenal-kylian-mbappe-mikel-arteta", 1, "Hate it!", articles.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}