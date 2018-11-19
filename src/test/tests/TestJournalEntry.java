package tests;

import model.Entry;
import model.JournalEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestJournalEntry {
    Date date = new Date();
    private Entry j;

    @BeforeEach
    public void runBefore(){

        j = new JournalEntry("", "");
    }

    @Test
    public void testCheckLengthEmpty(){
        j.setEntry("");
        assertFalse(j.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthShortEnough(){
        j.setEntry("Hello World");
        assertFalse(j.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthTooLong(){
        j.setEntry("Hello World this is a sample entry that is too long " +
                "it should not pass today my day was bad or good or I don't know" +
                "more words more words more words");
        assertFalse(j.checkLength(j.getEntry()));
    }


}
