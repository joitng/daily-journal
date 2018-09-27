package ui;

import model.DailyJournal;
import model.JournalEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public ArrayList<JournalEntry> allEntries = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public Date date = new Date();
    public DailyJournal dj = new DailyJournal();

    public Main(){
        String operation = "";
        while (true) {
            JournalEntry journal = new JournalEntry("", date, "");
            System.out.println("What would you like to do?");
            System.out.println("[1] Create a new journal entry");
            System.out.println("[2] View a journal entry");
            System.out.println("[3] Browse journal entries");
            System.out.println("[4] Quit");
            operation = scanner.nextLine();
            if (operation.equals("1")) {
                dj.create(journal);
                dj.addEntry(journal);
                dj.view(journal);
                journal.flipWritten();
            }

            if (operation.equals("2")){
                // Lets you enter the particular title and shows it to you
            }
            if (operation.equals("3")){
                // Lets you view all your journal entries
                // (hopefully in calendar mode)
            }
            else if (operation.equals("4")) {
                break;
            }
        }
        System.out.println("Goodbye! See you tomorrow!");
    }

    public static void main(String[] args) {
        new Main();

    }


}

