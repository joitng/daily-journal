package tests;

import model.DailyJournal;
import model.JournalEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDailyJournal {
    Date date = new Date();
    private JournalEntry j;
    private DailyJournal dj = new DailyJournal();

    @BeforeEach
    public void runBefore(){
        j = new JournalEntry("", date, "");
    }

    @Test
    public void testAddOneEntry(){
        dj.addEntry(j);
        ArrayList<JournalEntry> allEntries = dj.getAllEntries();
        assertEquals(1, allEntries.size());
        assertEquals(j, allEntries.get(0));
    }

    @Test
    public void testAddMultipleEntries(){
        ArrayList<JournalEntry> allEntries = dj.getAllEntries();
        JournalEntry j1 = new JournalEntry("", date, "");
        JournalEntry j2 = new JournalEntry("", date, "");
        dj.addEntry(j);
        dj.addEntry(j1);
        dj.addEntry(j2);
        assertEquals(3, allEntries.size());
        assertEquals(j, allEntries.get(0));
        assertEquals(j1, allEntries.get(1));
        assertEquals(j2, allEntries.get(2));
    }

    @Test
    public void testCheckLengthEmpty(){
        j.setEntry("");
        assertTrue(dj.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthShortEnough(){
        j.setEntry("Hello World");
        assertTrue(dj.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthTooLong(){
        j.setEntry("Hello World this is a sample entry that is too long " +
                "it should not pass today my day was bad or good or I don't know" +
                "more words more words more words");
        assertFalse(dj.checkLength(j.getEntry()));
    }
}
