package ui.tabs;

import model.ArticleStash;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.ArticleStashUI;
import ui.ButtonNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HomeTab extends Tab {
    private static final String INIT_GREETING = "ArticleStash";
    private final JsonReader jsonReader;
    private final JsonReader jsonReader2;
    private JLabel greeting;
    private ArticleStash wantToRead;
    private ArticleStash articlesRead;
    private JsonWriter jsonWriter;
    private JsonWriter jsonWriter2;
    private static final String JSON_STORE_ARTICLESREAD = "./data/articlesread.json";
    private static final String JSON_STORE_WANTTOREAD = "./data/wanttoread.json";

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(ArticleStashUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeHomeButtons();

        getController().init();

        jsonWriter = new JsonWriter(JSON_STORE_WANTTOREAD);
        jsonReader = new JsonReader(JSON_STORE_WANTTOREAD);

        jsonWriter2 = new JsonWriter(JSON_STORE_ARTICLESREAD);
        jsonReader2 = new JsonReader(JSON_STORE_ARTICLESREAD);

        articlesRead = getController().getArticlesRead();
        wantToRead = getController().getWantToRead();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.BOLD, 30));
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //EFFECTS: creates Arrive and Leave buttons that change greeting message when clicked
    private void placeHomeButtons() {
        JButton loadButton = new JButton(ButtonNames.LOAD.getName());
        JButton saveButton = new JButton(ButtonNames.SAVE.getName());
        JButton quitButton = new JButton(ButtonNames.QUIT.getName());

        JPanel buttonRow = formatButtonRow(loadButton);

        buttonRow.add(saveButton);
        buttonRow.add(quitButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        loadButtonAction(loadButton);

        saveButtonAction(saveButton);

        quitButtonAction(quitButton);

        this.add(buttonRow);
    }

    private static void quitButtonAction(JButton quitButton) {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void saveButtonAction(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveArticleStash();
            }
        });
    }

    private void loadButtonAction(JButton loadButton) {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadArticleStash();
            }
        });
    }

    // Code received from the JsonSerializationDemo from the project example provided.
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

    // Code received from the JsonSerializationDemo from the project example provided.
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
