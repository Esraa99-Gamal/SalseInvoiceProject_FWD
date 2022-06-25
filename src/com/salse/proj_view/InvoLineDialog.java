package com.salse.proj_view;

/**
 * 
 * @author IslamAmin
*/

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoLineDialog extends JDialog{
    private JTextField item_NameField;
    private JTextField item_CountField;
    private JTextField item_PriceField;
    private JLabel itemName_L;
    private JLabel itemCount_L;
    private JLabel itemPrice_L;
    private JButton addBton;
    private JButton cancelBton;
    
    public InvoLineDialog(InvoFrame frame) {
        item_NameField = new JTextField(24);
        itemName_L = new JLabel("Name");
        
        item_CountField = new JTextField(24);
        itemCount_L = new JLabel("Count");
        
        item_PriceField = new JTextField(24);
        itemPrice_L = new JLabel("Price");
        
        addBton = new JButton("Add");
        cancelBton = new JButton("Cancel");
        
        addBton.setActionCommand("c_LineAdd");
        cancelBton.setActionCommand("c_LineCancel");
        
        addBton.addActionListener(frame.getController());
        cancelBton.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        add(itemName_L);
        add(item_NameField);
        add(itemCount_L);
        add(item_CountField);
        add(itemPrice_L);
        add(item_PriceField);
        add(addBton);
        add(cancelBton);
        
        pack();
    }

    public JTextField getItemNameField() {
        return item_NameField;
    }

    public JTextField getItemCountField() {
        return item_CountField;
    }

    public JTextField getItemPriceField() {
        return item_PriceField;
    }
}
