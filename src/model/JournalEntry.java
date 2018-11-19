package model;


import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class JournalEntry extends Entry {

    // EFFECTS: constructs a JournalEntry
    public JournalEntry(String title, String entry){
        super(title, entry);
        this.tag = "normal";
    }

    // EFFECTS: returns true if entry is over 150 characters, false otherwise
    @Override
    public boolean checkLength(String entry){
        if (entry.length() > 150){
            return true;
        }

        else {
            return false;
        }
    }


}