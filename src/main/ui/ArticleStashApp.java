package ui;

import model.Article;
import model.ArticleStash;

import java.util.Scanner;

// This class contains the application that runs articleStash.
// It is primarily consisting of the main ui, and deals with user feedback,
// the interface of the project.
public class ArticleStashApp {
    private ArticleStash articlesRead;
    private ArticleStash wantToRead;
    private Scanner input;

    // EFFECTS: runs the article stash application
    public ArticleStashApp() {
        runArticleStash();
    }

    // Code received from the TellerApp from the project example provided.
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

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            doAddArticle();
        } else if (command.equals("remove")) {
            doRemoveArticle();
        } else if (command.equals("edit comment")) {
            doEditComment();
        } else if (command.equals("edit rating")) {
            doEditRating();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        articlesRead = new ArticleStash();
        wantToRead = new ArticleStash();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // Code received from the TellerApp from the project example provided.
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tadd: add article");
        System.out.println("\tremove: remove article");
        System.out.println("\tedit comment: edit comment on an article");
        System.out.println("\tedit rating: edit rating on an article");
        System.out.println("\tview articles: view all articles");
        System.out.println("\tquit: quit");
    }

    // Code received from the TellerApp from the project example provided.
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

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: conducts a remove article command
    private void doRemoveArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to remove: ");
        String article = input.next();
        selected.removeArticle(article);
        printArticles(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: conducts an edit comment on an article command
    private void doEditComment() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to edit: ");
        String article = input.next();
        System.out.print("Enter new comment: ");
        String comment = input.next();
        selected.editComment(article, comment);
        printArticles(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: conducts an edit comment on an article command
    private void doEditRating() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to edit: ");
        String article = input.next();
        System.out.print("Enter new rating: ");
        int rating = Integer.parseInt(input.next());
        selected.editRating(article, rating);
        printArticles(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: conducts an edit comment on an article command
    private void doViewArticle() {
        ArticleStash selected = selectList();
        System.out.print("These are  all the articles you've logged: ");
        selected.viewArticles();
        printArticles(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // EFFECTS: prompts user to select from list of read articles or aticles they want to
    // read, returns whatever the user selects
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

    // Code received from the TellerApp from the project example provided.
    // EFFECTS: prints articles read to the screen
    private void printArticles(ArticleStash selected) {
        System.out.printf("Articles read: " + selected.getNumOfArticles());
    }
}
