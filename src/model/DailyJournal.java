package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DailyJournal {
    public ArrayList<JournalEntry> allEntries = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public DailyJournal(){

    }

    // MODIFIES: journal
    // EFFECTS: adds a title and an entry to the journalEntry
    public void create(JournalEntry journalEntry){
        System.out.println("What do you want to call this journal entry?");
        String titleReply = scanner.nextLine();
        journalEntry.setTitle(titleReply);
        System.out.println("Write about your day!");
        String entryReply = scanner.nextLine();
        if (checkLength(entryReply)){
            System.out.println("Your entry today has been entered.");
            journalEntry.setEntry(entryReply);
        }
        else {
            while (!checkLength(entryReply)){
                System.out.println("Please edit! Your entry was too long.");
                System.out.println("Write about your day!");
                entryReply = scanner.nextLine();
                if (checkLength(entryReply)) {
                    System.out.println("Your entry today has been entered.");
                    journalEntry.setEntry(entryReply);
                }
            }
        }
    }

    // REQUIRES: an inputted journal entry
    // EFFECTS: lets the user view their journal entry
    public void view(JournalEntry journalEntry){
        System.out.println("Would you like to view your entry? " +
                "yes " +
                "no");
        String op = scanner.nextLine();
        if (op.equals("yes")) {
            System.out.println(journalEntry.getEntry());
        }

    }

    // REQUIRES: entry is < 140 characters long
    // MODIFIES: allEntries
    // EFFECTS: adds the new entry to the list of entries
    public void addEntry(JournalEntry newEntry){
        allEntries.add(newEntry);
    }

    // EFFECTS: returns the list of entries
    public ArrayList<JournalEntry> getAllEntries(){
        return allEntries;
    }

    // EFFECTS: returns false if entry is too long, false otherwise
    public boolean checkLength(String entry){
        if (entry.length() > 140){
            return false;
        }

        else {
            return true;
        }
    }

}
