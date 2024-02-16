package model;

import java.util.ArrayList;
import java.util.Objects;

public class ArticleStash {
    ArrayList<String> articleStash;
    private String user;

    // EFFECTS: constructs a user and provides amount of articles read
    // also initializes a log of articles that the user has classified
    // as read (a list)
    public ArticleStash(String userName) {
        articleStash = new ArrayList<>();
        user = userName;
    }

    public String getUser() {
        return user;
    }

    public ArrayList<String> getArticles() {
        return articleStash;
    }

    public int getNumOfArticles() {
        return articleStash.size();
    }

    // REQUIRES: string must start with https: & article cannot already
    // be in the list
    // MODIFIES: this
    // EFFECTS: adds an article to the log of articles
    public void addArticle(String article) {
        articleStash.add(article);
    }

    // REQUIRES: string must start with https: & article size must be > 0
    // MODIFIES: this
    // EFFECTS: remove an article from the log of articles
    public void removeArticle(String article) {
        articleStash.remove(article);
    }

}
