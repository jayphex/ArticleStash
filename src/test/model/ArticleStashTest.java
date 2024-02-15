package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleStashTest {
    private ArticleStash testArticleStash;

    @BeforeEach
    void runBefore() {
        testArticleStash = new ArticleStash("jay", 0);
    }

    @Test
    public void testConstructor() {
        assertEquals("jay", testArticleStash.getUser());
        assertEquals(0, testArticleStash.getUserStatistics());
    }

    @Test
    public void testAddArticle() {
    }

}