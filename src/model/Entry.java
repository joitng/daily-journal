package model;

import java.util.*;


public abstract class Entry extends Observable {
    private String title;
    private Date date;
    protected String entry;
    protected String tag;
    private DateManager dm;

    public Entry(String title, String entry) {
        this.title = title;
        this.date = new Date();
        this.entry = entry;
        dm = new DateManager();
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
        setChanged();
        notifyObservers();
    }

    // EFFECTS: sets the special tag to categorize the special entry
    public void setTag(String tag){
        this.tag = tag;
    }

    // EFFECTS: gets the special tag
    public String getTag(){
        return tag;
    }

    // EFFECTS: returns false if entry is too long, false otherwise
    public abstract boolean checkLength(String entry);


}
