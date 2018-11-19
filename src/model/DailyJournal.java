package model;

import exceptions.SameDateException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class DailyJournal implements Saveable, Loadable, Observer {
    private ArrayList<Entry> allEntries;
    private DateManager dm = new DateManager();

    public DailyJournal(){
        allEntries = new ArrayList<>();
    }

    // REQUIRES: entry is < 140 characters long
    // MODIFIES: allEntries
    // EFFECTS: adds the new entry to the list of entries
    public void addEntry(Entry newEntry){
            allEntries.add(newEntry);
    }

    // EFFECTS: returns the list of entries
    public ArrayList<Entry> getAllEntries(){
        return allEntries;
    }

    // EFFECTS: splits up line by two equal signs
    public static ArrayList<String> splitOnEquals(String line){
        String[] splits = line.split("==");
        return new ArrayList<>(Arrays.asList(splits));
    }

    // MODIFIES: filename
    // EFFECTS: saves the new entry
    @Override
    public void saveEntries(String filename) {
        loadEntries(filename);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UTF-8 is unknown");
        }
        for (Entry je:allEntries){
            writer.println(je.getTitle()+"=="+je.getEntry()+"=="+je.getDate()+"=="+je.getTag());
        }

        writer.close();
    }

    // EFFECTS: loads old entries
    @Override
    public void loadEntries(String filename) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Caught input/output exception");
        }
        if (lines.size() > 1){
            for (String line : lines) {
                ArrayList<String> partsOfLine = splitOnEquals(line);
                Entry je = new JournalEntry("", "");
                je.setTitle(partsOfLine.get(0));
                je.setEntry(partsOfLine.get(1));
                je.setDate(dm.stringToDate(partsOfLine.get(2)));
                je.setTag(partsOfLine.get(3));
                allEntries.add(je);
            }

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Entry) {
            Entry e = (Entry) o;

            System.out.println("Your entry " +e.getTitle()+ " has been entered!");

        }
    }
}
