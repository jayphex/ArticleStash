package model;

public class Article {
    private int articleRating;
    private String articleLink;
    private String articleComment;

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

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public void setArticleRating(int articleRating) {
        this.articleRating = articleRating;
    }
}
