package ui;

import model.Article;
import model.ArticleStash;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// This class contains the application that runs articleStash.
// It is primarily consisting of the main ui, and deals with user feedback,
// the interface of the project.
public class ArticleStashApp {
    private static final String JSON_STORE = "./data/articlestash.json";
    private ArticleStash articlesRead;
    private ArticleStash wantToRead;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the article stash application
    public ArticleStashApp() throws FileNotFoundException  {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
        } else if (command.equals("edit c")) {
            doEditComment();
        } else if (command.equals("edit r")) {
            doEditRating();
        } else if (command.equals("view")) {
            doViewArticle();
        } else if (command.equals("save")) {
            saveArticleStash();
        } else if (command.equals("load")) {
            loadArticleStash();
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
        System.out.println("\tedit c: edit comment on an article");
        System.out.println("\tedit r: edit rating on an article");
        System.out.println("\tview: view articles you've logged");
        System.out.println("\tload: load previous file");
        System.out.println("\tsave: save file you're working on");
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
        System.out.println(selected.viewArticles());
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

    // Code received from the JsonSerializationDemo from the project example provided.
    // EFFECTS: saves the article stash to file
    private void saveArticleStash() {
        ArticleStash selected = selectList();

        try {
            jsonWriter.open();
            jsonWriter.write(selected);
            jsonWriter.close();
            System.out.println("Saved file to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // Code received from the JsonSerializationDemo from the project example provided.
    // MODIFIES: this
    // EFFECTS: loads article stash from file
    private void loadArticleStash() {
        try {
            jsonReader.read();
            System.out.println("Loaded file from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
