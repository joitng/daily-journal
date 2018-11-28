package ui.panels;

import model.DailyJournal;
import model.JournalEntry;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRegularPanel {
    private JPanel regPanel;
    private JFrame frame;
    private JournalEntry journal;

    public CreateRegularPanel(JFrame curr){

        frame = curr;

        regPanel = new JPanel();

        regPanel.setBackground(Color.pink);

        regPanel.setBorder(BorderFactory.createTitledBorder("Tell me about your day! Write a journal entry"));

        JTextField nameField = new JTextField(30);
        JTextArea entryArea = new JTextArea(15,30);
        JLabel nameLabel = new JLabel("Title:");
        JLabel entryLabel = new JLabel("Entry: ");
        JLabel entryLength = new JLabel(" /150");
        JButton submitBtn = new JButton("I'm done writing!");
        JButton backButton = new JButton("Back to main menu");

        entryArea.setLineWrap(true);
        entryArea.setWrapStyleWord(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = nameField.getText();
                String entry = entryArea.getText();
                if (entry.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please write something before you press submit");
                } else {
                    journal = new JournalEntry(title, entry);

                    if (journal.checkLength(entry)) {
                        JOptionPane.showMessageDialog(null, "Your entry was too long! Please try again.");
                    } else {
                        DailyJournal dj = journal.getDj();
                        dj.addEntry(journal);
                        dj.saveEntries("savedentries.txt");

                        frame.remove(regPanel);
                        frame.setContentPane(new SubmittedPanel(frame).getPanel());
                        frame.setVisible(true);
                    }
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

        entryArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            public void update(){
                entryLength.setText(entryArea.getText().length()+" /150");
            }
        });

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
        regPanel.add(entryLength,gc);

        gc.gridy = 4;
        regPanel.add(submitBtn, gc);

        gc.gridy = 5;
        regPanel.add(backButton,gc);


    }

    public JPanel getPanel(){ return regPanel;}
}
