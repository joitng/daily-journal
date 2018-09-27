package model;


import java.util.Date;

public class JournalEntry {
    private String title;
    private Date date;
    private String entry;
    private boolean written = false;

    // EFFECTS: constructs a JournalEntry
    public JournalEntry(String title, Date date, String entry){
        this.title = title;
        this.date = date;
        this.entry = entry;
        this.written = written;
    }

    // EFFECTS: returns the title of the journal entry
    public String getTitle(){
        return title;
    }

    // EFFECTS: gives the journal entry a new title
    public void setTitle(String title){
        this.title = title;
    }

    // EFFECTS: returns the date of the journal entry
    public Date getDate(){
        return date;
    }

    // EFFECTS: sets the date of the journal entry
    public void setDate(Date date){
        this.date = date;

    }

    // EFFECTS: returns the passage of the journal entry
    public String getEntry(){
        return entry;
    }

    // EFFECTS: gives the journal entry an actual entry passage
    public void setEntry(String entry){
        this.entry = entry;
    }

    // EFFECTS: returns written
    public boolean getWritten(){
        return written;
    }

    // EFFECTS: sets the field written
    public void setWritten(boolean written){
        this.written = written;
    }

    // MODIFIES: this
    // EFFECTS: if written is true, changes it to false and vice versa
    public void flipWritten(){
        this.written = !written;
    }

    // MODIFIES: this
    // EFFECTS: checks if the entry is an empty entry, sets written to false if so
    public void isWritten(){
        if (entry.equals("")) {
            this.written = false;
        }
        else { this.written = true;
        }
    }


}