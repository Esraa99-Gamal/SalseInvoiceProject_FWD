
package com.salse.proj_view;

/**
 * @author IslamAmin
*/
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoDialog extends JDialog {
    private JTextField cust_NameField;
    private JTextField invo_DateField;
    private JLabel custName_L;
    private JLabel invDate_L;
    private JButton addBton;
    private JButton cancelBton;

    public InvoDialog(InvoFrame ssframe) {
        custName_L = new JLabel("Customer Name:");
        cust_NameField = new JTextField(24);
        invDate_L = new JLabel("Invoice Date:");
        invo_DateField = new JTextField(24);
        addBton = new JButton("Add");
        cancelBton = new JButton("Cancel");
        
        addBton.setActionCommand("c_InvoiceAdd");
        cancelBton.setActionCommand("c_InvoiceCancel");
        
        addBton.addActionListener(ssframe.getController());
        cancelBton.addActionListener(ssframe.getController());
        setLayout(new GridLayout(4, 3));
        
        add(invDate_L);
        add(invo_DateField);
        add(custName_L);
        add(cust_NameField);
        add(addBton);
        add(cancelBton);
        
        pack();
        
    }

    public JTextField getCustNameField() {
        return cust_NameField;
    }

    public JTextField getInvDateField() {
        return invo_DateField;
    }   
}