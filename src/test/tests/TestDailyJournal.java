package tests;

import model.DailyJournal;
import model.Entry;
import model.JournalEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDailyJournal {
    Date date = new Date();
    private Entry j;
    private DailyJournal dj = new DailyJournal();
    private ArrayList<Entry> allEntries;

    @BeforeEach
    public void runBefore(){

        j = new JournalEntry("", "");
        allEntries = new ArrayList<>();
    }

    @Test
    public void testAddOneEntry(){
        dj.addEntry(j);
        ArrayList<Entry> allEntries = dj.getAllEntries();
        assertEquals(1, allEntries.size());
        assertEquals(j, allEntries.get(0));
    }

    @Test
    public void testAddMultipleEntries(){
        ArrayList<Entry> allEntries = dj.getAllEntries();
        Entry j1 = new JournalEntry("", "");
        Entry j2 = new JournalEntry("", "");
        dj.addEntry(j);
        dj.addEntry(j1);
        dj.addEntry(j2);
        assertEquals(3, allEntries.size());
        assertEquals(j, allEntries.get(0));
        assertEquals(j1, allEntries.get(1));
        assertEquals(j2, allEntries.get(2));
    }

    @Test
    public void testSplitEqualsNoEquals(){
        String line = "blah blah blah";
        ArrayList<String> partsOfLine = dj.splitOnEquals(line);
        assertEquals("blah blah blah", partsOfLine.get(0));
    }

    @Test
    public void testSplitEqualsSomeEquals(){
        String line = "blah blah blah==blah blah==blah";
        ArrayList<String> partsOfLine = dj.splitOnEquals(line);
        assertEquals("blah blah blah", partsOfLine.get(0));
        assertEquals("blah blah", partsOfLine.get(1));
        assertEquals("blah", partsOfLine.get(2));
    }

    @Test
    public void testSaveEntries() throws IOException, ParseException {
        Entry j2 = new JournalEntry("Save test1","");
        j.setTitle("Save test2");
        j.setDate(j.stringToDate("Wed Oct 03 15:04:47 PDT 2018"));
        j2.setDate(j.stringToDate("Wed Oct 03 15:04:47 PDT 2018"));
        dj.addEntry(j);
        dj.addEntry(j2);
        dj.saveEntries("outputfile.txt");
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals("Save test2====Wed Oct 03 15:04:47 PDT 2018", lines.get(0));
        assertEquals("Save test1====Wed Oct 03 15:04:47 PDT 2018", lines.get(1));
    }

    @Test
    public void testLoadEntries() throws IOException, ParseException {
        dj.loadEntries("inputfile.txt");
        allEntries = dj.getAllEntries();
        Entry j0 = allEntries.get(0);
        Entry j1 = allEntries.get(1);
        assertEquals(j.stringToDate("Fri Oct 12 00:00:00 PDT 2018"), j0.getDate());
        assertEquals(j.stringToDate("Fri Oct 12 01:00:00 PDT 2018"), j1.getDate());

    }


}
