package tests;

import model.JournalEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJournalEntry {
    Date date = new Date();
    private JournalEntry j;

    @BeforeEach
    public void runBefore(){
        j = new JournalEntry("", date, "");
    }


    // Test that the journal entry is classified as written
    @Test
    public void testMakeWritten(){
        assertFalse(j.getWritten());
        j.flipWritten();
        assertTrue(j.getWritten());
    }

    // Test that the journal entry is declassified as written
    @Test
    public void testMakeUnWritten(){
        j.setWritten(true);
        assertTrue(j.getWritten());
        j.flipWritten();
        assertFalse(j.getWritten());
    }

    // Test that isWritten produces what is expected when the entry is empty
    @Test
    public void testisWrittenEmpty(){
        j.setEntry("");
        j.isWritten();
        assertFalse(j.getWritten());
    }

    // Test that isWritten produces what is expected when there is a valid entry
    @Test
    public void testisWrittenFull(){
        j.setEntry("Hello world");
        j.isWritten();
        assertTrue(j.getWritten());
    }


}
