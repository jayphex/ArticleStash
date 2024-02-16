package ui;

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

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        articlesRead = new ArticleStash("jay");
        wantToRead = new ArticleStash("jay");
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

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void doAddArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to add: ");
        String article = input.next();
        selected.addArticle(article);
        printArticles(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doRemoveArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to remove: ");
        String article = input.next();
        selected.removeArticle(article);
        printArticles(selected);
    }

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

    // EFFECTS: prints balance of account to the screen
    private void printArticles(ArticleStash selected) {
        System.out.printf("Articles read: " + selected.getArticles());
    }
}
