package tests;

import model.Entry;
import model.SpecialEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSpecialEntry {
    private Entry j;

    @BeforeEach
    public void runBefore(){
        j = new SpecialEntry("", "");
    }


    @Test
    public void testCheckLengthEmpty(){
        j.setEntry("");
        assertTrue(j.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthShortEnough(){
        j.setEntry("Hello World");
        assertTrue(j.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthOver150LessThan300(){
        j.setEntry("Hello World this is a sample entry that is too long " +
                "it should not pass today my day was bad or good or I don't know" +
                "more words more words more words");
        assertTrue(j.checkLength(j.getEntry()));
    }

    @Test
    public void testCheckLengthOver300(){
        j.setEntry("Hello World this is a sample entry that is too long " +
                "it should not pass today my day was bad or good or I don't know" +
                "more words more words more words more words more words" +
                "more words more words more words more words more words" +
                "more words more words more words more words more words");
        assertTrue(j.checkLength(j.getEntry()));
    }

}
