package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// This class represents a test for the Article Stash class.
class ArticleStashTest {
    private ArticleStash testArticleStash;

    @BeforeEach
    void runBefore() {
        testArticleStash = new ArticleStash();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    void testGetArticleLink() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                testArticle.getArticleLink());
    }

    @Test
    void testGetArticleRating() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(4,
                testArticle.getArticleRating());;
    }

    @Test
    void testGetArticleComment() {
        Article testArticle = new Article("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals("Love Hailu Mergia!",
                testArticle.getArticleComment());
    }



    @Test
    void getNumOfArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    void testAddArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
    }

    @Test
    void testAddMultipleArticles() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.phillymag.com/news/2021/02/20/sonia-sanchez-poetry/",
                4, "Love Sonia Sanchez!");
        assertEquals(2, testArticleStash.getNumOfArticles());
    }


    @Test
    void testRemoveArticle() {
        assertEquals(0, testArticleStash.getNumOfArticles());
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertEquals(1, testArticleStash.getNumOfArticles());
        testArticleStash.removeArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi");
        assertEquals(0, testArticleStash.getNumOfArticles());
    }

    @Test
    void testRemoveMultipleArticles() {
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

    @Test
    void testEditComment() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        testArticleStash.editComment("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
        "I love him even more!");
        assertEquals("I love him even more!", testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleComment()); ;
    }

    @Test
    void testEditCommentFailed() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        testArticleStash.editComment("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-tax",
                "I love him even more!");
        assertEquals("Love Hailu Mergia!", testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleComment()); ;
    }

    @Test
    void testEditRating() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        testArticleStash.editRating("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                5);
        assertEquals(5, testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleRating());
    }

    @Test
    void testEditRatingFailed() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        testArticleStash.editRating("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-tax",
                5);
        assertEquals(4, testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleRating());
    }

    @Test
    void testFindArticle() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                5, "Love Hailu Mergia!");
        assertEquals("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleLink());
        assertEquals("Love Hailu Mergia!",
                testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleComment());
        assertEquals(5,
                testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi").getArticleRating());
    }

    @Test
    void testFindArticleFailed() {
        testArticleStash.addArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-taxi",
                4, "Love Hailu Mergia!");
        assertNull(testArticleStash.findArticle("https://www.theguardian.com/music/2018/mar/01/hailu-mergia-the-ethiopian-jazz-legend-who-jams-in-his-tax"));
    }
}