package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmittedPanel {
    private JPanel submitPanel;
    private JFrame frame;

    public SubmittedPanel(JFrame curr){
        // TODO: make prettier??? This is a good place to add a picture/graphix

        frame = curr;
        submitPanel = new JPanel();

        submitPanel.setBorder(BorderFactory.createTitledBorder("Your entry has been saved!"));

        JLabel submitMsg = new JLabel("Have a nice day!");
        JButton menuBtn = new JButton("Main menu");

        menuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(submitPanel);
                frame.setContentPane(new StartPanel(frame).getPanel());
                frame.setVisible(true);
            }
        });

        submitPanel.setBackground(Color.green);
        submitPanel.setLayout(new BorderLayout());

        submitPanel.add(submitMsg,BorderLayout.CENTER);
        submitPanel.add(menuBtn,BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return submitPanel;
    }
}
