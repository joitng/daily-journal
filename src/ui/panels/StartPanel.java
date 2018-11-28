package ui.panels;

import model.DailyJournal;
import model.DateManager;
import model.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class StartPanel {
    private JPanel startPanel;
    private JFrame frame;
    private DateManager dm = new DateManager();

    public StartPanel(JFrame curr){

        frame = curr;

        startPanel = new JPanel();

        Date date = new Date();

        startPanel.setBackground(Color.pink);

        JLabel startLabel = new JLabel("What would you like to do?");


        // Set layout manager
        startPanel.setLayout(new BorderLayout());

        JButton createRegButton = new JButton("Create a new regular journal entry");
        JButton createSpecButton = new JButton("Create a new special journal entry");
        JButton viewSpecCategory = new JButton("View a special journal entry category");
        JButton viewMostRecent = new JButton("What was the last thing I wrote?");


        createRegButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (dm.sameDate(date,dm.mostRecentDate())){
                    JOptionPane.showMessageDialog(null,"Sorry, you've already written an entry for today!");
                }
                else {
                    frame.remove(startPanel);
                    frame.setContentPane(new CreateRegularPanel(frame).getPanel());
                    frame.setVisible(true);
                }
            }
        });

        createSpecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dm.sameDate(date,dm.mostRecentDate())){
                    JOptionPane.showMessageDialog(null,"Sorry, you've already written an entry for today!");
                }
                else {
                    frame.remove(startPanel);
                    frame.setContentPane(new CreateSpecialPanel(frame).getPanel());
                    frame.setVisible(true);
                }
            }
        });

        viewSpecCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startPanel);
                frame.setContentPane(new ViewSpecialPanel(frame).getPanel());
                frame.setVisible(true);
            }
        });

        viewMostRecent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyJournal dj = new DailyJournal();
                dj.loadEntries("savedentries.txt");
                ArrayList<Entry> allEntries = dj.getAllEntries();
                Entry mostRecent = allEntries.get(0);
                JOptionPane.showMessageDialog(null,mostRecent.getEntry());
            }
        });

        startPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        startPanel.add(startLabel, gc);

        gc.gridy = 1;
        startPanel.add(createRegButton, gc);

        gc.gridy = 2;
        startPanel.add(createSpecButton, gc);

        gc.gridy = 3;
        startPanel.add(viewSpecCategory, gc);

        gc.gridy = 4;
        startPanel.add(viewMostRecent,gc);

    }

    public JPanel getPanel(){
        return startPanel;
    }
}
