package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class DailyJournal implements Saveable, Loadable {
    private ArrayList<Entry> allEntries;
    private Scanner scanner = new Scanner(System.in);

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
    public void saveEntries(String filename) throws IOException, ParseException {
        loadEntries(filename);
        PrintWriter writer = new PrintWriter(filename, "UTF-8");
        for (Entry je:allEntries){
            writer.println(je.getTitle()+"=="+je.getEntry()+"=="+je.getDate()+"=="+je.getTag());
        }

        writer.close();
    }

    // EFFECTS: loads old entries
    @Override
    public void loadEntries(String filename) throws IOException, ParseException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        if (lines.size() > 1){
            for (String line : lines) {
                ArrayList<String> partsOfLine = splitOnEquals(line);
                Entry je = new JournalEntry("", "");
                je.setTitle(partsOfLine.get(0));
                je.setEntry(partsOfLine.get(1));
                je.setDate(je.stringToDate(partsOfLine.get(2)));
                je.setTag(partsOfLine.get(3));
                allEntries.add(je);
            }

        }
    }
}
