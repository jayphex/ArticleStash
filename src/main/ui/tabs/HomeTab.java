package ui.tabs;

import ui.ArticleStashUI;
import ui.ButtonNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTab extends Tab {
    private static final String INIT_GREETING = "ArticleStash";

    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(ArticleStashUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeHomeButtons();

        getController().init();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        JLabel greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
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
                getController().saveArticleStash();
            }
        });
    }

    private void loadButtonAction(JButton loadButton) {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().loadArticleStash();
            }
        });
    }
}
