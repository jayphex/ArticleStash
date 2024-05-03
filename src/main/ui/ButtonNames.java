package ui;

// This class holds the names of the buttons for the GUI.

public enum ButtonNames {
    ADD("Add Article"),
    REMOVE("Remove Article"),
    EDIT_COMMENT("Edit Comment"),
    EDIT_RATING("Edit Rating"),
    VIEW("View Articles"),
    LOAD("Load"),
    SAVE("Save"),
    MENU("Menu"),
    QUIT("Quit");

    private final String name;

    ButtonNames(String name) {
        this.name = name;
    }

    // EFFECTS: returns name of button
    public String getName() {
        return name;
    }
}
