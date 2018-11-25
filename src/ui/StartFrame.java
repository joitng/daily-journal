package ui;

import model.JournalEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class StartFrame extends JFrame {

    public StartFrame(String title){
        super(title);

        JLabel startLabel = new JLabel("What would you like to do?");


        // Set layout manager
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.orange);

        JButton createRegButton = new JButton("Create a new regular journal entry");
        JButton createSpecButton = new JButton("Create a new special journal entry");
        JButton viewSpecCategory = new JButton("View a special journal entry category");

        createRegButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        createSpecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        viewSpecCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        add(startLabel, gc);

        gc.gridy = 1;
        add(createRegButton, gc);

        gc.gridy = 2;
        add(createSpecButton, gc);

        gc.gridy = 3;
        add(viewSpecCategory, gc);

    }
}
