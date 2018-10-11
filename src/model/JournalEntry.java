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

    // EFFECTS: returns false if entry is over 150 characters, true otherwise
    @Override
    public boolean checkLength(String entry){
        if (entry.length() > 150){
            return false;
        }

        else {
            return true;
        }
    }


}