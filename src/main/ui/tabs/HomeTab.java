package ui.tabs;

import model.Event;
import model.EventLog;
import ui.ArticleStashUI;
import ui.ButtonNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

// This class represents the Home tab of the GUI, this tab contains three buttons.
// Here, the user can save the application, reload the previous application that was
// saved or quit the application.
public class HomeTab extends Tab {
    private static final String INIT_GREETING = "ArticleStash";

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(ArticleStashUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeHomeButtons();
        placeImage();

        getController().init();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        JLabel greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setFont(new Font("Arial", Font.BOLD, 30));
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    //EFFECTS: places image in the console
    private void placeImage() {
        ImageIcon newspaper = new ImageIcon("images/betternewspaper.png");
        JLabel image = new JLabel(newspaper);
        image.setSize(WIDTH, HEIGHT / 3);
        this.add(image);
    }

    //EFFECTS: creates Load Save and Quit buttons that either load the previous file saved,
    // save the current file or quit the whole program
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

    // EFFECTS: exits the application
    private static void quitButtonAction(JButton quitButton) {
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: saves the ArticleStash
    private void saveButtonAction(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().saveArticleStash();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: saves the ArticleStash
    private void loadButtonAction(JButton loadButton) {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().loadArticleStash();
            }
        });
    }
}
