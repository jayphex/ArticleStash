package model;

import model.exceptions.ArticleAlreadyAddedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleStashTest {
    private ArticleStash testArticleStash;

    @BeforeEach
    void runBefore() {
        testArticleStash = new ArticleStash("jay");
    }

    @Test
    public void testConstructor() {
        assertEquals("jay", testArticleStash.getUser());
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testGetUser() {
        assertEquals("jay", testArticleStash.getUser());
    }

    @Test
    public void testGetArticles() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        ArrayList<String> newArticleStash = new ArrayList<>();
        newArticleStash.add("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(newArticleStash, testArticleStash.getArticles());
    }

    @Test
    public void getNumOfArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testAddArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testAddMultipleArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(2, testArticleStash.getNumOfArticles());
    }


    @Test
    public void testRemoveArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testRemoveMultipleArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(2, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

}