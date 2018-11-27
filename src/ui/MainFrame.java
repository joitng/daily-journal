package ui;

import exceptions.NoSuchTagException;
import model.SpecialEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private DetailsPanel detailsPanel;
    private SpecialEntry se;

    public MainFrame(String title){
        super(title);
        se = new SpecialEntry("","");

        // Set layout manager
        setLayout(new BorderLayout());

        // Create Swing component
        JTextArea textArea = new JTextArea();

        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener() {

                                           @Override
                                           public void detailEventOccurred(DetailEvent event) {
                                               try {
                                                   ArrayList<String> entries = se.findEntry(event.getText());
                                                   for (String e:entries){
                                                       textArea.append(e);
                                                   }
                                               } catch (NoSuchTagException e) {
                                                   textArea.append("That tag doesn't exist!");
                                               }

                                           }
            });


        // Add Swing components to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);

    }


}
