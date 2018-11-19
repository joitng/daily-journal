package ui;

import exceptions.SameDateException;
import model.*;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private DailyJournal dj = new DailyJournal();
    private DateManager dm = new DateManager();
    private ReadWebPage web = new ReadWebPage();

    public Main() {
        String operation = "";
        while (true) {
            Entry journal = new JournalEntry("", "");
            SpecialEntry special = new SpecialEntry("","");
            web.parse();
            System.out.println("What would you like to do?");
            System.out.println("[1] Create a new regular journal entry");
            System.out.println("[2] Create a new special journal entry");
            System.out.println("[3] View a special journal entry category");
            System.out.println("[4] Browse");
            System.out.println("QUIT");
            operation = scanner.nextLine();
            if (operation.equals("1")) {

                try{
                    create(journal);
                    dj.addEntry(journal);
                    view(journal);
                    dj.saveEntries("savedentries.txt");
                } catch (SameDateException e) {
                    System.out.println("Sorry, you can't make two journal entries on the same day!");
                } finally {
                    System.out.println("Have a nice day!");
                }
            }

            if (operation.equals("2")){
                try {
                    create(special);
                    dj.addEntry(special);
                    System.out.println("How would you like to categorize this special entry?");
                    String specialTag = scanner.nextLine();
                    special.setTag(specialTag);
                    view(special);
                    dj.saveEntries("savedentries.txt");
                } catch (SameDateException e) {
                    System.out.println("Sorry, you can't make two journal entries on the same day!");
                } finally {
                    System.out.println("Have a nice day!");
                }

            }

            if (operation.equals("3")){
                System.out.println("Tell us the name of the category you'd like to view!");
                String op = scanner.nextLine();
                try{
                    ArrayList<String> specialEntries = special.findEntry(op);
                    for (String s: specialEntries) {
                        System.out.println(s);

                    }
                }
                catch(Exception e){
                    System.out.println("Sorry, I couldn't find anything with that tag!");
                }


            }
            if (operation.equals("4")){
            }
            else if (operation.equals("QUIT")) {
                break;
            }
        }
        System.out.println("Goodbye! See you tomorrow!");
    }

    public void create(Entry e) throws SameDateException {
        Date date = new Date();
        if (dm.sameDate(date, dm.mostRecentDate())){
            throw new SameDateException();
        }
        System.out.println("What do you want to call this journal entry?");
        String titleReply = scanner.nextLine();
        e.setTitle(titleReply);
        writeAndSave(e);
    }

    private void writeAndSave(Entry e){
        e.addObserver(dj);
        System.out.println("Write about your day!");
        String entryReply = scanner.nextLine();
        if (!e.checkLength(entryReply)){
            e.setEntry(entryReply);
        } else {
            System.out.println("Please rewrite! Your entry was too long.");
            writeAndSave(e);
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

    public static void main(String[] args) {
        new Main();

    }


}

