package ui.tabs;

import model.Article;
import ui.ArticleStashUI;


import javax.swing.*;
import java.awt.*;

// This class represents the Want To Read tab of the GUI, this tab contains four buttons.
// Here, the user can add an article to the Want To Read section of the ArticleStash as well
// as view all the articles they have added to the Want To Read section thus far.
public class ArticlesWantToReadTab extends ArticlesTab {

    public ArticlesWantToReadTab(ArticleStashUI controller) {
        super(controller);
    }

    // MODIFIES: this
    // EFFECTS: Filters the articles that have all been added thus far, if the article
    // has the same rating as the rating the user inputted then display the article.
    protected void yesOption() {
        StringBuilder wantToRead = new StringBuilder();
        String input = JOptionPane.showInputDialog(this, "Input the rating you would like to filter articles by:");
        try {
            int rating = Integer.parseInt(input);

            for (Article article : getController().getWantToRead().getArticles()) {
                if (article.getArticleRating() == rating) {
                    wantToRead.append(article.getArticleLink()).append("\n");
                    wantToRead.append("Rating: ").append(article.getArticleRating()).append("\n");
                    wantToRead.append("Comment: ").append(article.getArticleComment()).append("\n");
                    wantToRead.append("\n");
                }
            }

            JTextArea textArea = new JTextArea(wantToRead.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(600, 400));

            JOptionPane.showMessageDialog(this, scrollPane, "Articles", JOptionPane.PLAIN_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid rating, please select a number between 1-5!",
                    "INVALID", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Displays all the articles that the user has added thus far.
    protected void noOption() {
        StringBuilder wantToRead = new StringBuilder();
        for (Article article : getController().getWantToRead().getArticles()) {
            wantToRead.append(article.getArticleLink()).append("\n");
            wantToRead.append("Rating: ").append(article.getArticleRating()).append("\n");
            wantToRead.append("Comment: ").append(article.getArticleComment()).append("\n");
            wantToRead.append("\n");
        }

        JTextArea textArea = new JTextArea(wantToRead.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Articles", JOptionPane.PLAIN_MESSAGE);
    }
}
