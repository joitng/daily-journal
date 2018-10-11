package model;

import java.io.IOException;
import java.text.ParseException;

public interface Saveable {

    // MODIFIES: savedentries.txt
    // EFFECTS: saves the new entry
    void saveEntries(String filename) throws IOException, ParseException;
}
