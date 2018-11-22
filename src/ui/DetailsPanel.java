package ui;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {

    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Other things you can do"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel titleLabel = new JLabel("Title: ");

        JTextField nameField = new JTextField(10);
        JTextField titleField = new JTextField(10);

        JButton addBtn = new JButton("Add");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // First column

        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;

        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(titleLabel, gc);

        // Second column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(titleLabel,gc);

        // Final row
        gc.weighty = 10;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);

    }
}
