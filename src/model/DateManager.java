package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DateManager {

    // REQUIRES: string of date in E MMM dd HH:mm:ss zzz yyyy
    // MODIFIES: typedDate
    // EFFECTS: changes String to Date
    // taken from <https://www.javatpoint.com/java-string-to-date>
    public Date stringToDate(String typedDate) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").parse(typedDate);
        } catch (ParseException e) {
            System.out.println("Date is not written in proper format");
        }

        return date1;
    }

    // EFFECTS: returns true if the given date is the same as the current date
    public boolean sameDate(Date date1, Date date2){

        String givenDate = new SimpleDateFormat("dd-MM").format(date1);
        String currentDate = new SimpleDateFormat("dd-MM").format(date2);
        if (givenDate.equals(currentDate)){
            return true;
        }

        return false;
    }

    // EFFECTS: returns date of the most recent entry
    public Date mostRecentDate(){
        DailyJournal dj = new DailyJournal();
        dj.loadEntries("savedentries.txt");
        ArrayList<Entry> allEntries = dj.getAllEntries();
        Entry mostRecent = allEntries.get(0);
        return mostRecent.getDate();
    }
}
