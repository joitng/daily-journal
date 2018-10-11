package model;

public class SpecialEntry extends Entry{


    public SpecialEntry(String title, String entry) {
        super(title, entry);
    }

    // EFFECTS: returns false if entry is over 300 characters, true otherwise
    @Override
    public boolean checkLength(String entry) {
        if (entry.length() > 300){
            return false;
        }

        else {
            return true;
        }
    }


}
