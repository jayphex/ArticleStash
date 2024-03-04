package model;

import org.json.JSONObject;
import persistence.Writable;

// This class constructs an article, the information within this class
// deals with setters and getters for the article class. These are then
// used as elements within the ArticleStash list.
public class Article implements Writable {
    private int articleRating;
    private String articleLink;
    private String articleComment;

    // EFFECTS: constructs an article with an article rating, an article comment, and the
    // article's link
    public Article(String articleLink, int articleRating, String articleComment) {
        this.articleLink = articleLink;
        this.articleRating = articleRating;
        this.articleComment = articleComment;
    }

    public int getArticleRating() {
        return articleRating;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public String getArticleComment() {
        return articleComment;
    }

    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }

    public void setArticleRating(int articleRating) {
        this.articleRating = articleRating;
    }
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("articleLink", articleLink);
        json.put("articleRating", articleRating);
        json.put("articleComment", articleComment);
        return json;
    }
}
