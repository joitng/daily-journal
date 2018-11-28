package ui.panels;

import ui.DetailEvent;
import ui.DetailListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsPanel extends JPanel {
    JButton backBtn;

    private EventListenerList listenerList = new EventListenerList();

    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 300;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("View a special category!"));

        setBackground(Color.pink);

        JLabel title = new JLabel("What category would you like to view?");

        final JTextField textField = new JTextField(15);

        JButton addBtn = new JButton("Show me what I've written!");

        backBtn = new JButton("Back to main menu");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryName = textField.getText();

                fireDetailEvent(new DetailEvent(this,categoryName));
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // First column

        gc.anchor = GridBagConstraints.PAGE_START;
        gc.weightx = 0.5;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(title, gc);

        // Second column
        gc.gridx = 1;
        gc.gridy = 1;
        add(textField, gc);

        // Final row
        gc.weighty = 10;

        gc.gridx = 1;
        gc.gridy = 2;
        add(addBtn, gc);

        gc.weighty = 30;
        gc.gridx = 1;
        gc.gridy = 5;
        add(backBtn, gc);

    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = listenerList.getListenerList();

        for(int i=0; i < listeners.length; i += 2){
            if(listeners[i] == DetailListener.class){
                ((DetailListener)listeners[+1]).detailEventOccurred(event);
            }
        }
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void addDetailListener(DetailListener listener){
        listenerList.add(DetailListener.class,listener);
    }

    public void removeDetailListener(DetailListener listener){
        listenerList.remove(DetailListener.class,listener);
    }
}
