package ui.tabs;

import ui.ArticleStashUI;

import javax.swing.*;
import java.awt.*;

// This class represents the abstract class for the Tabs of the GUI.
public abstract class Tab extends JPanel {

    private final ArticleStashUI controller;

    //REQUIRES: ArticleStashUI controller that holds this tab
    public Tab(ArticleStashUI controller) {
        this.controller = controller;
    }

    // Sourced from https://github.students.cs.ubc.ca/CPSC210/LongFormProblemSolutions.git
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

