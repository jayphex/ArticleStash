package ui.tabs;

import ui.ArticleStashUI;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel {

    private final ArticleStashUI controller;

    //REQUIRES: ArticleStashUI controller that holds this tab
    public Tab(ArticleStashUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the ArticleStashUI controller for this tab
    public ArticleStashUI getController() {
        return controller;
    }

}

