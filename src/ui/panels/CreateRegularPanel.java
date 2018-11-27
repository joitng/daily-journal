package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRegularPanel {
    private JPanel regPanel;
    private JFrame frame;

    public CreateRegularPanel(JFrame curr){
        // TODO: If possible, character counter
        // TODO: Doesn't allow enter if character counter is over
        // TODO: End frame after exit button click?? Can be used for other 3 as well

        frame = curr;

        regPanel = new JPanel();

        JLabel panelLabel = new JLabel("Tell me about your day!");
        JTextField nameField = new JTextField(20);
        JTextArea entryArea = new JTextArea(15,20);
        JLabel nameLabel = new JLabel("Title:");
        JLabel entryLabel = new JLabel("Entry: ");
        JButton submitBtn = new JButton("I'm done writing!");
        JButton backButton = new JButton("Back to main menu");

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        gc.gridx = 1;
        gc.gridy = 0;
        regPanel.add(panelLabel, gc);

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
