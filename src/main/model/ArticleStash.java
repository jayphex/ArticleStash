package model;

import java.util.ArrayList;
import java.util.Objects;

// This class contains the list of articles that the user has stashed, and
// provides holds the information of which articles the user has stashed either
// in their want to reads or the list of books they've already read.

public class ArticleStash {
    ArrayList<Article> articleStash;

    // EFFECTS: constructs a user and provides amount of articles read
    // also initializes a log of articles that the user has classified
    // as read (a list)
    public ArticleStash() {
        articleStash = new ArrayList<>();
    }

    public ArrayList<Article> getArticles() {
        return articleStash;
    }

    public int getNumOfArticles() {
        return articleStash.size();
    }

    // REQUIRES: string must start with https: & article cannot already
    // be in the list
    // MODIFIES: this
    // EFFECTS: adds an article to the log of articles
    public void addArticle(String link, int rating, String comment) {
        articleStash.add(new Article(link, rating, comment));
    }

    // REQUIRES: string must start with https: & article size must be > 0
    // MODIFIES: this
    // EFFECTS: remove an article from the log of articles
    public void removeArticle(String link) {
        articleStash.removeIf(a -> link.equals(a.getArticleLink()));
    }

    // MODIFIES: this
    // EFFECTS: edits a comment in an article log
    public void editComment(Article article, String comment) {
        for (Article a : articleStash) {
            if (Objects.equals(a.getArticleLink(), article.getArticleLink())) {
                a.setArticleComment(comment);
            }
        }
    }

    // REQUIRES: rating > 0 & < 5
    // MODIFIES: this
    // EFFECTS: edits a rating in an article log
    public void editRating(Article article, int rating) {
        for (Article a : articleStash) {
            if (Objects.equals(a.getArticleLink(), article.getArticleLink())) {
                a.setArticleRating(rating);
            }
        }
    }
}
