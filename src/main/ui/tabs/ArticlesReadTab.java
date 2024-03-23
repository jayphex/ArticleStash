package ui.tabs;

import model.Article;
import model.ArticleStash;
import ui.ArticleStashUI;
import ui.ButtonNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArticlesReadTab extends Tab {
    private final ArticleStash articlesRead;

    public ArticlesReadTab(ArticleStashUI controller) {
        super(controller);

        setLayout(new GridLayout(0, 1));

        placeArticlesReadButtons();

        articlesRead = getController().getArticlesRead();
    }

    private void placeArticlesReadButtons() {
        JButton addArticleButton = new JButton(ButtonNames.ADD.getName());
        JButton editCommentButton = new JButton(ButtonNames.EDIT_COMMENT.getName());
        JButton editRatingButton = new JButton(ButtonNames.EDIT_RATING.getName());
        JButton viewArticlesButton = new JButton(ButtonNames.VIEW.getName());

        JPanel buttonRow = formatButtonRow(addArticleButton);
        buttonRow.add(editCommentButton);
        buttonRow.add(editRatingButton);
        buttonRow.add(viewArticlesButton);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        addArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addArticle();
            }
        });

        viewArticlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewArticles();
            }
        });

        this.add(buttonRow);
    }

    private void addArticle() {
        JTextField titleField = new JTextField(20);
        JTextField ratingField = new JTextField(5);
        JTextField commentField = new JTextField(20);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Link:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Rating:"));
        inputPanel.add(ratingField);
        inputPanel.add(new JLabel("Comment:"));
        inputPanel.add(commentField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel,
                "Add Article", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            int rating = Integer.parseInt(ratingField.getText());
            String comment = commentField.getText();
            articlesRead.addArticle(title, rating, comment);
            JOptionPane.showMessageDialog(null, "Article added successfully!");
        }
    }

    private void viewArticles() {
        List<Article> articleStash = articlesRead.getArticles();

        StringBuilder articlesRead = new StringBuilder();
        for (Article article : articleStash) {
            articlesRead.append(article.getArticleLink()).append("\n");
            articlesRead.append("Rating: ").append(article.getArticleRating()).append("\n");
            articlesRead.append("Comment: ").append(article.getArticleComment()).append("\n");
            articlesRead.append("\n");
        }

        JTextArea textArea = new JTextArea(articlesRead.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Articles", JOptionPane.PLAIN_MESSAGE);
    }
}
