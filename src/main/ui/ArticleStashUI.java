package ui;

import model.ArticleStash;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.ArticlesWantToReadTab;
import ui.tabs.HomeTab;
import ui.tabs.ArticlesReadTab;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private final JsonWriter jsonWriter;
    private final JsonWriter jsonWriter2;
    private final JsonReader jsonReader;
    private final JsonReader jsonReader2;

    public static final int HOME_TAB_INDEX = 0;
    public static final int ARTICLES_READ_INDEX = 1;
    public static final int ARTICLES_WANT_INDEX = 2;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private final JTabbedPane topbar;

    // Semi-sourced from https://github.students.cs.ubc.ca/CPSC210/LongFormProblemSolutions.git
    // EFFECTS: constructor for the ArticleStashApp
    public ArticleStashUI() throws FileNotFoundException {
        super("Article Stash");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                printEventLogs();
            }
        });

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

    private static void printEventLogs() {
        for (Event event : EventLog.getInstance()) {
            System.out.println("Date: " + event.getDate());
            System.out.println("Description: " + event.getDescription());
        }
        EventLog.getInstance().clear();
        System.exit(0);
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
    // MODIFIES: this
    // EFFECTS: initializes ArticleStashes
    public void init() {
        articlesRead = new ArticleStash();
        wantToRead = new ArticleStash();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
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
