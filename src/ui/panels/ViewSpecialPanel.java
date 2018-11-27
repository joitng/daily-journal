package ui.panels;

import exceptions.NoSuchTagException;
import model.SpecialEntry;
import ui.DetailEvent;
import ui.DetailListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewSpecialPanel {
    private DetailsPanel detailsPanel;
    private JFrame frame;
    private JPanel viewSpec;
    private SpecialEntry se;


    public ViewSpecialPanel(JFrame curr){

        frame = curr;

        viewSpec = new JPanel();

        viewSpec.setLayout(new BorderLayout());

        se = new SpecialEntry("","");

        JTextArea textArea = new JTextArea();

        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener() {
            @Override
            public void detailEventOccurred(DetailEvent event) {
                try {
                    ArrayList<String> entries = se.findEntry(event.getText());
                    for (String e:entries) {
                        e = e+ "\n";
                        textArea.append(e);

                    }
                } catch (NoSuchTagException e) {
                    textArea.append("That tag doesn't exist!");
                }

            }
        });

        detailsPanel.getBackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(viewSpec);
                frame.setContentPane(new StartPanel(frame).getPanel());
                frame.setVisible(true);
            }
        });

        viewSpec.add(textArea, BorderLayout.CENTER);
        viewSpec.add(detailsPanel, BorderLayout.WEST);
    }

    public JPanel getPanel(){ return viewSpec;}

}
