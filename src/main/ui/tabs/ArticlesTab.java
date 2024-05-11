package ui.tabs;

import model.Article;
import ui.ArticleStashUI;
import ui.ButtonNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ArticlesTab extends Tab {

    public ArticlesTab(ArticleStashUI controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        placeArticlesReadButtons();
    }

    // MODIFIES: this
    // EFFECTS: places the buttons associated with the Articles Read tab.
    private void placeArticlesReadButtons() {
        JButton addArticleButton = new JButton(ButtonNames.ADD.getName());
        JButton editCommentButton = new JButton(ButtonNames.EDIT_COMMENT.getName());
        JButton editRatingButton = new JButton(ButtonNames.EDIT_RATING.getName());
        JButton viewArticlesButton = new JButton(ButtonNames.VIEW.getName());
        JButton removeArticleButton = new JButton(ButtonNames.REMOVE.getName());

        JPanel buttonRow = formatButtonRow(addArticleButton);
        buttonRow.add(editCommentButton);
        buttonRow.add(editRatingButton);
        buttonRow.add(removeArticleButton);
        buttonRow.add(viewArticlesButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        addArticleAction(addArticleButton);

        editCommentAction(editCommentButton);

        editRatingAction(editRatingButton);

        removeArticleAction(removeArticleButton);

        viewArticlesAction(viewArticlesButton);

        this.add(buttonRow);
    }

    private void viewArticlesAction(JButton viewArticlesButton) {
        viewArticlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewArticles();
            }
        });
    }

    private void removeArticleAction(JButton removeArticleButton) {
        removeArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeArticle();
            }
        });
    }

    private void editRatingAction(JButton editRatingButton) {
        editRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRating();
            }
        });
    }

    private void editCommentAction(JButton editCommentButton) {
        editCommentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editComment();
            }
        });
    }

    private void addArticleAction(JButton addArticleButton) {
        addArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addArticle();
            }
        });
    }

    // MODIFIES: ArticlesRead, this
    // EFFECTS: adds the Article inputted by the user to the ArticleStash
    private void addArticle() {
        JTextField titleField = new JTextField(20);
        JTextField ratingField = new JTextField(5);
        JTextField commentField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Link:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Rating (between 1-5):"));
        inputPanel.add(ratingField);
        inputPanel.add(new JLabel("Comment:"));
        inputPanel.add(commentField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Add Article", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            int rating = Integer.parseInt(ratingField.getText());
            String comment = commentField.getText();
            getController().getArticlesRead().addArticle(title, rating, comment);
            JOptionPane.showMessageDialog(null, "Article added!");
        }
    }

    // MODIFIES: ArticlesRead, this
    // EFFECTS: edits the comment of the article associated with the ArticleStash
    private void editComment() {
        JTextField titleField = new JTextField(20);
        JTextField commentField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.add(new JLabel("Link:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Comment: "));
        inputPanel.add(commentField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Edit Comment", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String link = titleField.getText();
            String comment = commentField.getText();
            getController().getArticlesRead().editComment(link, comment);
            JOptionPane.showMessageDialog(null, "Article's comment changed!");
        }
    }

    // MODIFIES: ArticlesRead, this
    // EFFECTS: removes the Article inputted by the user from the ArticleStash, if found
    private void editRating() {
        JTextField titleField = new JTextField(20);
        JTextField ratingField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));
        inputPanel.add(new JLabel("Link:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Comment: "));
        inputPanel.add(ratingField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Edit Rating", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String link = titleField.getText();
            int rating = Integer.parseInt(ratingField.getText());
            getController().getArticlesRead().editRating(link, rating);
            JOptionPane.showMessageDialog(null, "Article's rating changed!");
        }
    }


    private void removeArticle() {
        JTextField titleField = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 1));
        inputPanel.add(new JLabel("Link:"));
        inputPanel.add(titleField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Remove Article", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String link = titleField.getText();
            getController().getArticlesRead().removeArticle(link);
            JOptionPane.showMessageDialog(null, "Article removed!");
        }
    }

    // EFFECTS: Provides a prompt for the user to view all the articles they've added thus far,
    // the user can also filter the articles if they would like
    protected void viewArticles() {
        int option = JOptionPane.showConfirmDialog(this,
                "Would you like to view articles filtered to a specific rating?",
                "View Articles", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            yesOption();
        } else {
            noOption();
        }
    }

    protected abstract void yesOption();

    protected abstract void noOption();


}
