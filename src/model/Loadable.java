package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface Loadable {

    // EFFECTS: loads old entries
    void loadEntries(String filename);
}
