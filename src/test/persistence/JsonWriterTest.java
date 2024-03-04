package persistence;

import model.Article;
import model.ArticleStash;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// This class represents a JsonWriter test. It tests a non-existent file,
// an empty ArticleStash as well as an ArticleStash of 2 articles.
public class JsonWriterTest extends JsonTest {
    // Code received from the JsonSerializationDemo from the project example provided.
    @Test
    void testWriterInvalidFile() {
        try {
            ArticleStash ar = new ArticleStash();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // This should happen.
        }
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    @Test
    void testWriterEmptyArticleStash() {
        try {
            ArticleStash as = new ArticleStash();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyArticleStash.json");
            writer.open();
            writer.write(as);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyArticleStash.json");
            as = reader.read();
            assertEquals(0, as.getNumOfArticles());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralArticleStash() {
        try {
            ArticleStash as = new ArticleStash();
            as.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi", 5, "Love it!");
            as.addArticle("https://www.theguardian.com/football/2024/feb/16/arsenal-kylian-mbappe-mikel-arteta", 1, "Hate it!");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(as);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            as = reader.read();
            List<Article> articles = as.getArticles();
            assertEquals(2, articles.size());
            checkArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi", 5, "Love it!", articles.get(0));
            checkArticle("https://www.theguardian.com/football/2024/feb/16/arsenal-kylian-mbappe-mikel-arteta", 1, "Hate it!", articles.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
