package model;

import java.util.ArrayList;

public class ArticleStash {
    ArrayList<String> articleStash;
    private String user;
    private int articlesRead;

    // EFFECTS: constructs a user and provides amount of articles read
    // also initializes a log of articles that the user has classified
    // as read (a list)
    public ArticleStash(String userName, int initialArticlesRead) {
        articleStash = new ArrayList<>();
        user = userName;
        articlesRead = initialArticlesRead;
        System.out.println("Welcome" + getUser());
        System.out.println("Here are the articles you have read so far:" + articleStash);
    }

    // REQUIRES: string must start with https:
    // MODIFIES: this
    // EFFECTS: adds an article to the log of articles
    public void addArticle(String article) {
        System.out.println("What article have you read?");
        articleStash.add(article);
        System.out.println(articleStash.get(0) + "has been added");
    }

    // REQUIRES: string must start with https:
    // MODIFIES: this
    // EFFECTS: remove an article from the log of articles
    public void removeArticle(String article) {
        System.out.println("What article do you want to remove?");
        articleStash.remove(article);
        System.out.println(article + " has been removed");
    }

    // MODIFIES: this
    // EFFECTS: returns the amount of articles the user read this year
    public void userStatistics() {
        System.out.println("You have read " + getUserStatistics());
        System.out.println("articles this year.");
    }


    public String getUser() {
        return user;
    }

    public ArrayList<String> getArticles() {
        return articleStash;
    }

    public int getUserStatistics() {
        return articlesRead;
    }

}
