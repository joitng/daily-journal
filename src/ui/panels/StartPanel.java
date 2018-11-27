package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel {
    private JPanel startPanel;
    private JFrame frame;

    public StartPanel(JFrame curr){
        frame = curr;

        startPanel = new JPanel();

        JLabel startLabel = new JLabel("What would you like to do?");


        // Set layout manager
        startPanel.setLayout(new BorderLayout());

        startPanel.setBackground(Color.orange);

        JButton createRegButton = new JButton("Create a new regular journal entry");
        JButton createSpecButton = new JButton("Create a new special journal entry");
        JButton viewSpecCategory = new JButton("View a special journal entry category");


        createRegButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startPanel);
                frame.setContentPane(new CreateRegularPanel(frame).getPanel());
                frame.setVisible(true);
            }
        });

        createSpecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startPanel);
                frame.setContentPane(new CreateSpecialPanel(frame).getPanel());
                frame.setVisible(true);
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

    }

    public JPanel getPanel(){
        return startPanel;
    }
}
