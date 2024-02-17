package ui;

import model.Article;
import model.ArticleStash;

import java.util.Scanner;

public class ArticleStashApp {
    private ArticleStash articlesRead;
    private ArticleStash wantToRead;
    private Scanner input;

    // EFFECTS: runs the article stash application
    public ArticleStashApp() {
        runArticleStash();
    }

    // Received from TellerApp
    private void runArticleStash() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("That's all!");
    }

    // Received from TellerApp
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            doAddArticle();
        } else if (command.equals("remove")) {
            doRemoveArticle();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // Received from TellerApp
    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        articlesRead = new ArticleStash();
        wantToRead = new ArticleStash();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd: add article");
        System.out.println("\tremove: remove article");
        System.out.println("\tquit: quit");
    }

    // Received from TellerApp
    // MODIFIES: this
    // EFFECTS: conducts an add article command
    private void doAddArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to add: ");
        String article = input.next();
        System.out.print("Enter the rating you would give the article: ");
        int rating = Integer.parseInt(input.next());
        System.out.print("Enter the comment you would like to add about the article: ");
        String comment = input.next();
        selected.addArticle(article, rating, comment);
        printArticles(selected);
    }

    // Received from TellerApp
    // MODIFIES: this
    // EFFECTS: conducts a remove article command
    private void doRemoveArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to remove: ");
        String article = input.next();
        selected.removeArticle(article);
        printArticles(selected);
    }

    // Received from TellerApp
    // EFFECTS: prompts user to select chequing or savings account and returns it
    private ArticleStash selectList() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("read") || selection.equals("want to read"))) {
            System.out.println("read for articles read");
            System.out.println("want to read for articles read-list");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("read")) {
            return articlesRead;
        } else {
            return wantToRead;
        }
    }

    // Received from TellerApp
    // EFFECTS: prints articles read to the screen
    private void printArticles(ArticleStash selected) {
        System.out.printf("Articles raad: " + selected.getNumOfArticles());
    }
}
