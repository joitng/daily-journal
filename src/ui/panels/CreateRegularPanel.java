package ui.panels;

import model.DailyJournal;
import model.JournalEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRegularPanel {
    private JPanel regPanel;
    private JFrame frame;
    private JournalEntry journal;

    public CreateRegularPanel(JFrame curr){
        // TODO: If possible, character counter

        frame = curr;

        regPanel = new JPanel();

        regPanel.setBorder(BorderFactory.createTitledBorder("Tell me about your day! Write a journal entry"));

        JTextField nameField = new JTextField(30);
        JTextArea entryArea = new JTextArea(15,30);
        JLabel nameLabel = new JLabel("Title:");
        JLabel entryLabel = new JLabel("Entry: ");
        JButton submitBtn = new JButton("I'm done writing!");
        JButton backButton = new JButton("Back to main menu");

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = nameField.getText();
                String entry = entryArea.getText();
                journal = new JournalEntry(title,entry);

                if(journal.checkLength(entry)){
                    JOptionPane.showMessageDialog(null,"Your entry was too long! Please try again.");
                }
                else {
                    DailyJournal dj = journal.getDj();
                    dj.addEntry(journal);
                    dj.saveEntries("savedentries.txt");

                    frame.remove(regPanel);
                    frame.setContentPane(new SubmittedPanel(frame).getPanel());
                    frame.setVisible(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(regPanel);
                frame.setContentPane(new StartPanel(frame).getPanel());
                frame.setVisible(true);
            }
        });

        regPanel.setBackground(Color.cyan);
        regPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        regPanel.add(nameLabel,gc);

        gc.gridy = 2;
        regPanel.add(entryLabel,gc);

        gc.gridx = 1;
        gc.gridy = 1;
        regPanel.add(nameField, gc);

        gc.gridy = 2;
        regPanel.add(entryArea, gc);

        gc.gridy = 3;
        regPanel.add(submitBtn, gc);

        gc.gridy = 4;
        regPanel.add(backButton,gc);


    }

    public JPanel getPanel(){ return regPanel;}
}
