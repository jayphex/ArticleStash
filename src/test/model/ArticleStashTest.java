package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArticleStashTest {
    private ArticleStash testArticleStash;

    @BeforeEach
    void runBefore() {
        testArticleStash = new ArticleStash();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testGetArticleLink() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                testArticle.getArticleLink());
    }

    @Test
    public void testGetArticleRating() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(4,
                testArticle.getArticleRating());;
    }

    @Test
    public void testGetArticleComment() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals("Love Hailu Mergia!",
                testArticle.getArticleComment());
    }



    @Test
    public void getNumOfArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testAddArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testAddMultipleArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.phillymag.com/news/2021/02/20/sonia-sanchez-poetry/",
                4, "Love Sonia Sanchez!");
        assertEquals(2, testArticleStash.getNumOfArticles());
    }


    @Test
    public void testRemoveArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    public void testRemoveMultipleArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust",
                4, "Interesting conversation about Timbuktu!");
        assertEquals(2, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/cities/2014/sep/16/-sp-life-timbuktu-mali-ancient-city-gold-slowly-turning-to-dust");
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

}