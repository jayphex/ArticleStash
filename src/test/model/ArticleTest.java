package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This class represents a test for the Article class.
public class ArticleTest {
    private Article testArticle;

    @BeforeEach
    void runBefore() {
        testArticle = new Article("na", 4, "cool!");
    }

    @Test
    void testToString() {
        assertEquals("\n" + testArticle.getArticleLink() + "\n" +  "Rating: " + testArticle.getArticleRating()
                + "\n" + "Comments: " + testArticle.getArticleComment() + "\n", testArticle.toString());
    }
}
