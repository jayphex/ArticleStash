package persistence;

import model.Article;
import static org.junit.jupiter.api.Assertions.assertEquals;

// This class tests that the article saved to the Json file is the article
// that should be expected. This is then used within the JsonReader
// and JsonWriter tests.
public class JsonTest {
    protected void checkArticle(String articleLink, int articleRating, String articleComment, Article article) {
        assertEquals(articleLink, article.getArticleLink());
        assertEquals(articleRating, article.getArticleRating());
        assertEquals(articleComment, article.getArticleComment());
    }
}