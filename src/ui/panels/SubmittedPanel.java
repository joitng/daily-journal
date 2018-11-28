package ui.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.sun.tools.internal.xjc.reader.Ring.add;

public class SubmittedPanel {
    private JPanel submitPanel;
    private JFrame frame;

    public SubmittedPanel(JFrame curr){

        frame = curr;
        submitPanel = new JPanel();

        submitPanel.setBackground(Color.pink);

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

        ImageIcon image = new ImageIcon("have-a-nice-day.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);

        submitPanel.setLayout(new BorderLayout());

        submitPanel.add(label,BorderLayout.CENTER);
        submitPanel.add(menuBtn,BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return submitPanel;
    }
}
