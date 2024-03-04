package ui;

import model.ArticleStash;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Main {
    // Code received from the JsonSerializationDemo from the project example provided.
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new ArticleStashApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
