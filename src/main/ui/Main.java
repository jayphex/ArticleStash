package ui;

import java.io.FileNotFoundException;

public class Main {
    // Code received from the JsonSerializationDemo from the project example provided.
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new ArticleStashUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
