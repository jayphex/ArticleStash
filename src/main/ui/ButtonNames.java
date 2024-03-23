package ui;

// Holds the names of the buttons for the GUI.
// Semi-sourced from https://github.students.cs.ubc.ca/CPSC210/LongFormP
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
