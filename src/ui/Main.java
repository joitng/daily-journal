package ui;

import model.DailyJournal;
import model.Entry;
import model.JournalEntry;
import model.SpecialEntry;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private DailyJournal dj = new DailyJournal();

    public Main() throws IOException, ParseException {
        String operation = "";
        while (true) {
            Entry journal = new JournalEntry("", "");
            SpecialEntry special = new SpecialEntry("","");
            System.out.println("What would you like to do?");
            System.out.println("[1] Create a new regular journal entry");
            System.out.println("[2] Create a new special journal entry");
            System.out.println("[3] View a special journal entry category");
            System.out.println("[4] Browse journal entries");
            System.out.println("QUIT");
            operation = scanner.nextLine();
            if (operation.equals("1")) {
                create(journal);
                dj.addEntry(journal);
                view(journal);
                dj.saveEntries("savedentries.txt");
            }

            if (operation.equals("2")){
                create(special);
                dj.addEntry(special);
                System.out.println("How would you like to categorize this special entry?");
                String specialTag = scanner.nextLine();
                special.setTag(specialTag);
                view(special);
                dj.saveEntries("savedentries.txt");

            }

            if (operation.equals("3")){
                ArrayList<String> specialEntries = findEntry();
                try{
                    for (String s: specialEntries) {
                        System.out.println(s);

                    }
                }
                catch(Exception e){
                    System.out.println("Sorry, I couldn't find anything with that tag!");
                }


            }
            if (operation.equals("4")){
                // Lets you view all your journal entries
                // (hopefully in calendar mode)
            }
            else if (operation.equals("QUIT")) {
                break;
            }
        }
        System.out.println("Goodbye! See you tomorrow!");
    }

    // MODIFIES: journal
    // EFFECTS: adds a title and an entry to the journalEntry
    private void create(Entry entry){
        System.out.println("What do you want to call this journal entry?");
        String titleReply = scanner.nextLine();
        entry.setTitle(titleReply);
        System.out.println("Write about your day!");
        String entryReply = scanner.nextLine();
        if (entry.checkLength(entryReply)){
            System.out.println("Your entry today has been entered.");
            entry.setEntry(entryReply);
        }
        else {
            while (!entry.checkLength(entryReply)){
                System.out.println("Please edit! Your entry was too long.");
                System.out.println("Write about your day!");
                entryReply = scanner.nextLine();
                if (entry.checkLength(entryReply)) {
                    System.out.println("Your entry today has been entered.");
                    entry.setEntry(entryReply);
                }
            }
        }
    }

    // REQUIRES: an inputted journal entry
    // EFFECTS: lets the user view their journal entry
    private void view(Entry entry){
        System.out.println("Would you like to view your entry? " +
                "yes " +
                "no");
        String op = scanner.nextLine();
        if (op.equals("yes")) {
            System.out.println(entry.getEntry());
        }

    }

    public ArrayList<String> findEntry() throws IOException, ParseException {
        System.out.println("Tell us the name of the category you'd like to view!");
        String op = scanner.nextLine();
        dj.loadEntries("savedentries.txt");
        ArrayList<Entry> allEntries = dj.getAllEntries();
        ArrayList<String> specialEntries = new ArrayList<>();
        for (Entry j: allEntries){
            if (op.equals(j.getTag())){
                specialEntries.add(j.getEntry());
            }

        }

        return specialEntries;
    }

    public static void main(String[] args) throws IOException, ParseException {
        new Main();

    }


}

