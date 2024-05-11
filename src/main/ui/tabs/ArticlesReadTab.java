package ui.tabs;

import model.Article;
import ui.ArticleStashUI;

import javax.swing.*;
import java.awt.*;

// This class represents the Articles Read tab of the GUI, this tab contains four buttons.
// Here, the user can add an article to the Articles Read section of the ArticleStash as well
// as view all the articles they have added to the Read section thus far.
public class ArticlesReadTab extends ArticlesTab {
    public ArticlesReadTab(ArticleStashUI controller) {
        super(controller);
    }


    // MODIFIES: this
    // EFFECTS: Filters the articles that have all been added thus far, if the article
    // has the same rating as the rating the user inputted then display the article.
    protected void yesOption() {
        StringBuilder articlesRead = new StringBuilder();
        String input = JOptionPane.showInputDialog(this, "Input the rating you would like to filter articles by:");
        try {
            int rating = Integer.parseInt(input);

            for (Article article : getController().getArticlesRead().getArticles()) {
                if (article.getArticleRating() == rating) {
                    articlesRead.append(article.getArticleLink()).append("\n");
                    articlesRead.append("Rating: ").append(article.getArticleRating()).append("\n");
                    articlesRead.append("Comment: ").append(article.getArticleComment()).append("\n");
                    articlesRead.append("\n");
                }
            }

            JTextArea textArea = new JTextArea(articlesRead.toString());
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
        StringBuilder articlesRead = new StringBuilder();
        for (Article article : getController().getArticlesRead().getArticles()) {
            articlesRead.append(article.getArticleLink()).append("\n");
            articlesRead.append("Rating: ").append(article.getArticleRating()).append("\n");
            articlesRead.append("Comment: ").append(article.getArticleComment()).append("\n");
            articlesRead.append("\n");
        }

        JTextArea textArea = new JTextArea(articlesRead.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Articles", JOptionPane.PLAIN_MESSAGE);
    }
}
