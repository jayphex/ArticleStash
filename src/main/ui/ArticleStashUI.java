package ui;

import model.Article;
import model.ArticleStash;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.ArticlesWantToReadTab;
import ui.tabs.HomeTab;
import ui.tabs.ArticlesReadTab;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// This class contains the application that runs articleStash.
// It is primarily consisting of the main ui, and deals with user feedback,
// the interface of the project.
public class ArticleStashUI extends JFrame {
    private static final String JSON_STORE_ARTICLESREAD = "./data/articlesread.json";
    private static final String JSON_STORE_WANTTOREAD = "./data/wanttoread.json";

    private ArticleStash articlesRead;
    private ArticleStash wantToRead;

    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonWriter jsonWriter2;
    private JsonReader jsonReader;
    private JsonReader jsonReader2;

    public static final int HOME_TAB_INDEX = 0;
    public static final int ARTICLES_READ_INDEX = 1;
    public static final int ARTICLES_WANT_INDEX = 2;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane topbar;

    // Semi-sourced from https://github.students.cs.ubc.ca/CPSC210/LongFormProblemSolutions.git
    // EFFECTS: constructor for the ArticleStashApp
    public ArticleStashUI() throws FileNotFoundException  {
        super("Article Stash");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        topbar = new JTabbedPane();
        topbar.setTabPlacement(JTabbedPane.TOP);

        loadTabs();
        add(topbar);

        setVisible(true);

        input = new Scanner(System.in);

        jsonWriter = new JsonWriter(JSON_STORE_WANTTOREAD);
        jsonReader = new JsonReader(JSON_STORE_WANTTOREAD);

        jsonWriter2 = new JsonWriter(JSON_STORE_ARTICLESREAD);
        jsonReader2 = new JsonReader(JSON_STORE_ARTICLESREAD);

        init();
    }

    // EFFECTS: returns the ArticlesRead ArticleStash
    public ArticleStash getArticlesRead() {
        return articlesRead;
    }

    // EFFECTS: returns the WantToRead ArticleStash
    public ArticleStash getWantToRead() {
        return wantToRead;
    }

    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);

        topbar.add(homeTab, HOME_TAB_INDEX);
        topbar.setTitleAt(HOME_TAB_INDEX, "Home");

        JPanel articlesReadTab = new ArticlesReadTab(this);

        topbar.add(articlesReadTab, ARTICLES_READ_INDEX);
        topbar.setTitleAt(ARTICLES_READ_INDEX, "Read");

        JPanel articlesWantToReadTab = new ArticlesWantToReadTab(this);

        topbar.add(articlesWantToReadTab, ARTICLES_WANT_INDEX);
        topbar.setTitleAt(ARTICLES_WANT_INDEX, "Want To Read");
    }

    // Code received from the TellerApp from the project example provided.
    // EFFECTS: runs an ArticleStash
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
    // EFFECTS: initializes ArticleStashes
    public void init() {
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
        printArticlesRead(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: conducts a remove article command
    private void doRemoveArticle() {
        ArticleStash selected = selectList();
        System.out.print("Enter article you would like to remove: ");
        String article = input.next();
        selected.removeArticle(article);
        printArticlesRead(selected);
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
        printArticlesRead(selected);
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
        printArticlesRead(selected);
    }

    // Code received from the TellerApp from the project example provided.
    // MODIFIES: this
    // EFFECTS: views on an article command
    private void doViewArticle() {
        ArticleStash selected = selectList();
        System.out.print("These are  all the articles you've logged: ");
        for (Article a : selected.getArticles()) {
            System.out.println(a);
        }
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
    private void printArticlesRead(ArticleStash selected) {
        System.out.printf("Articles read: " + selected.getNumOfArticles());
    }

    // Sourced from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    // EFFECTS: saves the article stash to file
    public void saveArticleStash() {
        try {
            jsonWriter.open();
            jsonWriter2.open();
            jsonWriter.write(wantToRead);
            jsonWriter2.write(articlesRead);
            jsonWriter.close();
            jsonWriter2.close();
            JOptionPane.showMessageDialog(this, "ArticleStash file saved!", "Save", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error saving files to "
                    + JSON_STORE_WANTTOREAD + " & " + JSON_STORE_ARTICLESREAD);
        }
    }

    // Sourced from https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
    // MODIFIES: this
    // EFFECTS: loads article stash from file
    public void loadArticleStash() {
        try {
            wantToRead = jsonReader.read();
            articlesRead = jsonReader2.read();
            JOptionPane.showMessageDialog(this, "Loaded ArticleStash file!", "Load", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to read file from: " + JSON_STORE_WANTTOREAD
                    + " & " + JSON_STORE_ARTICLESREAD);
        }
    }
}
