package model;

import exceptions.NoSuchTagException;

import java.util.ArrayList;

public class SpecialEntry extends Entry{


    public SpecialEntry(String title, String entry) {
        super(title, entry);
    }

    // EFFECTS: returns true if entry is over 300 characters, false otherwise
    @Override
    public boolean checkLength(String entry) {
        if (entry.length() > 300){
            return true;
        }

        else {
            return false;
        }
    }

    public ArrayList<String> findEntry(String op) throws NoSuchTagException {
        DailyJournal dj = new DailyJournal();
        dj.loadEntries("savedentries.txt");
        ArrayList<Entry> allEntries = dj.getAllEntries();
        ArrayList<String> specialEntries = new ArrayList<>();
        for (Entry j: allEntries){
            if (op.equals(j.getTag())){
                specialEntries.add(j.getEntry());
            }

        }

        if(specialEntries.size() == 0){
            throw new NoSuchTagException();
        }

        return specialEntries;
    }


}
