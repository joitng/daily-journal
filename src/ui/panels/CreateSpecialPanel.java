package ui.panels;

import model.DailyJournal;
import model.JournalEntry;
import model.SpecialEntry;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSpecialPanel {
    private JPanel specPanel;
    private JFrame frame;
    private SpecialEntry journal;

    public CreateSpecialPanel(JFrame curr){

        frame = curr;

        specPanel = new JPanel();
        specPanel.setBackground(Color.pink);

        specPanel.setBorder(BorderFactory.createTitledBorder("Spill the beans! Write a special entry"));

        JTextField nameField = new JTextField(30);
        JTextField tag = new JTextField(30);
        JLabel entryLength = new JLabel("/300");
        JLabel tagLabel = new JLabel("Tag:");
        JTextArea entryArea = new JTextArea(10,30);
        JLabel nameLabel = new JLabel("Title:");
        JLabel entryLabel = new JLabel("Entry: ");
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
                    journal = new SpecialEntry(title, entry);
                    if (journal.checkLength(entry)) {
                        JOptionPane.showMessageDialog(null, "Your entry was too long! Please try again.");
                    } else {
                        journal.setTag(tag.getText());
                        DailyJournal dj = journal.getDj();
                        dj.addEntry(journal);
                        dj.saveEntries("savedentries.txt");

                        frame.remove(specPanel);
                        frame.setContentPane(new SubmittedPanel(frame).getPanel());
                        frame.setVisible(true);
                    }

                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(specPanel);
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
                entryLength.setText(entryArea.getText().length()+" /300");
            }
        });

        specPanel.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 0.1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 1;
        specPanel.add(nameLabel,gc);

        gc.gridy = 2;
        specPanel.add(tagLabel,gc);

        gc.gridy = 3;
        specPanel.add(entryLabel,gc);

        gc.gridx = 1;
        gc.gridy = 1;
        specPanel.add(nameField, gc);

        gc.gridy = 2;
        specPanel.add(tag,gc);

        gc.gridy = 3;
        specPanel.add(entryArea, gc);

        gc.gridy = 4;
        specPanel.add(entryLength,gc);

        gc.gridy = 5;
        specPanel.add(submitBtn, gc);

        gc.gridy = 6;
        specPanel.add(backButton,gc);
    }

    public JPanel getPanel(){ return specPanel;}
}
