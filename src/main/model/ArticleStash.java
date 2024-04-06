package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class contains the list of articles that the user has stashed, and
// provides holds the information of which articles the user has stashed either
// in their want to reads or the list of books they've already read.
public class ArticleStash implements Writable {
    private List<Article> articleStash;

    // EFFECTS: constructs a user and provides amount of articles read
    // also initializes a log of articles that the user has classified
    // as read (a list)
    public ArticleStash() {
        articleStash = new ArrayList<>();
    }

    public int getNumOfArticles() {
        return articleStash.size();
    }

    // REQUIRES: link must start with https: & article cannot already
    // be in the list
    // MODIFIES: this
    // EFFECTS: adds an article to the log of articles
    public void addArticle(String link, int rating, String comment) {
        articleStash.add(new Article(link, rating, comment));
        EventLog.getInstance().logEvent(new Event("Added this article: " + (new Article(link, rating, comment))));
    }

    // REQUIRES: link must start with https: & article size must be > 0
    // MODIFIES: this
    // EFFECTS: remove an article from the log of articles
    public void removeArticle(String link) {
        articleStash.removeIf(a -> link.equals(a.getArticleLink()));
        EventLog.getInstance().logEvent(new Event("Removed this article: " + findArticle(link)));
    }

    // MODIFIES: this
    // EFFECTS: edits a comment in an article log
    public void editComment(String link, String comment) {
        for (Article a : articleStash) {
            if (link.equals(a.getArticleLink())) {
                a.setArticleComment(comment);
                EventLog.getInstance().logEvent(new Event("Edited this article's comment: " + findArticle(link)));
            }
        }
    }

    // REQUIRES: rating > 0 & < 5
    // MODIFIES: this
    // EFFECTS: edits a rating in an article log
    public void editRating(String link, int rating) {
        for (Article a : articleStash) {
            if (link.equals(a.getArticleLink())) {
                a.setArticleRating(rating);
                EventLog.getInstance().logEvent(new Event("Edited this article's rating: " + findArticle(link)));
            }
        }
    }

    // EFFECTS: finds an article given a link, if there isn't an article
    // to be found then return null
    public Article findArticle(String link) {
        for (Article a : articleStash) {
            if (link.equals(a.getArticleLink())) {
                return a;
            }
        }
        return null;
    }

    // EFFECTS: returns all the articles within a log
    public List<Article> getArticles() {
        return articleStash;
    }

    // Sourced from JsonSerializationDemo
    // EFFECTS: returns articles as a JSON.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("articles", articlesToJson());
        return json;
    }

    // Sourced from JsonSerializationDemo
    // EFFECTS: returns articles in this ArticleStash as a JSON array
    private JSONArray articlesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Article a : articleStash) {
            jsonArray.put(a.toJson());
        }

        return jsonArray;
    }
}
