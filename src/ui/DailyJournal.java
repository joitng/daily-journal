package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class DailyJournal {
    ArrayList<JournalEntry> allEntries = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public DailyJournal(){
        String operation = "";
        while (true) {
            JournalEntry journal = new JournalEntry();
            System.out.println("What would you like to do? " +
                    "[1] Create a new journal entry " +
                    "[2] View a journal entry " +
                    "[3] Browse journal entries " +
                    "[4] Quit");
            operation = scanner.nextLine();
            if (operation.equals("1")) {
                String result = create(journal);
                // add JournalEntry to allEntries
                System.out.println("Would you like to view your entry? " +
                        "yes " +
                        "no");
                scanner.nextLine();
                if (operation.equals("yes"));
                System.out.println(result);
            }

            if (operation.equals("2")){
                // Lets you enter the particular date and shows it to you
            }
            if (operation.equals("3")){
                // Lets you view all your journal entries
                // (hopefully in calendar mode)
            }
            else if (operation.equals("4")) {
                break;
            }
            System.out.println("Your entry today has been entered.");
        }
        System.out.println("Goodbye! See you tomorrow!");
    }

    private String create(JournalEntry journalEntry){
        System.out.println("What is the date today? Please write D/M/Y");
        String dateReply = scanner.nextLine();
        System.out.println("Please enter your journal entry for today.");
        String entryReply = scanner.nextLine();
        journalEntry.makeDate(dateReply);
        journalEntry.makeEntry(entryReply);
        return entryReply;
    }

    public void addEntry(JournalEntry newEntry){
        allEntries.add(newEntry);
    }


    public static void main(String[] args) {
        new DailyJournal();

    }


}

