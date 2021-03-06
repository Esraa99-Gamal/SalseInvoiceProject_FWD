
package com.salse.proj_view;

import com.salse.proj_controller.Proj_Controller;
import com.salse.proj_model.Invo_table;
import com.salse.proj_model.Invoice;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author esraa
 */
public class InvoFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    public InvoFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_Invoice = new javax.swing.JTable();
        t_Invoice.getSelectionModel().addListSelectionListener(controller);
        b_NewInvoice = new javax.swing.JButton();
        b_NewInvoice.addActionListener(controller);
        b_DeleteInvoice = new javax.swing.JButton();
        b_DeleteInvoice.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_InvoiceTotal = new javax.swing.JTable();
        b_NewItem = new javax.swing.JButton();
        b_NewItem.addActionListener(controller);
        b_DeleteItem = new javax.swing.JButton();
        b_DeleteItem.addActionListener(controller);
        l_InvoNUM = new javax.swing.JLabel();
        l_InvoDATA = new javax.swing.JLabel();
        l_CustNAME = new javax.swing.JLabel();
        l_InvoTOTAL = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_LoadFile = new javax.swing.JMenuItem();
        mi_LoadFile.addActionListener(controller);
        mi_SaveFile = new javax.swing.JMenuItem();
        mi_SaveFile.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t_Invoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(t_Invoice);

        b_NewInvoice.setText("New Invoice");
        b_NewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_NewInvoiceActionPerformed(evt);
            }
        });

        b_DeleteInvoice.setText("Delete Invoice");
        b_DeleteInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DeleteInvoiceActionPerformed(evt);
            }
        });

        jLabel1.setText("     Invoice_Number");

        jLabel2.setText("Invoice_Data");

        jLabel3.setText("Customer_Name");

        jLabel4.setText("Invoice_Total");

        t_InvoiceTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(t_InvoiceTotal);

        b_NewItem.setText("New Item");
        b_NewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_NewItemActionPerformed(evt);
            }
        });

        b_DeleteItem.setText("Delete Item");
        b_DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DeleteItemActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mi_LoadFile.setText("Load File");
        jMenu1.add(mi_LoadFile);

        mi_SaveFile.setText("Save File");
        jMenu1.add(mi_SaveFile);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(b_NewInvoice)
                        .addGap(73, 73, 73)
                        .addComponent(b_DeleteInvoice))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_NewItem)
                        .addGap(101, 101, 101)
                        .addComponent(b_DeleteItem)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l_InvoTOTAL, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_CustNAME, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_InvoNUM, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(l_InvoDATA, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_NewInvoice)
                            .addComponent(b_DeleteInvoice)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(l_InvoNUM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(l_InvoDATA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(l_CustNAME))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(l_InvoTOTAL))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_DeleteItem)
                            .addComponent(b_NewItem))))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_NewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_NewItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_NewItemActionPerformed

    private void b_NewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_NewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_NewInvoiceActionPerformed

    private void b_DeleteInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DeleteInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_DeleteInvoiceActionPerformed

    private void b_DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DeleteItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_DeleteItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_DeleteInvoice;
    private javax.swing.JButton b_DeleteItem;
    private javax.swing.JButton b_NewInvoice;
    private javax.swing.JButton b_NewItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_CustNAME;
    private javax.swing.JLabel l_InvoDATA;
    private javax.swing.JLabel l_InvoNUM;
    private javax.swing.JLabel l_InvoTOTAL;
    private javax.swing.JMenuItem mi_LoadFile;
    private javax.swing.JMenuItem mi_SaveFile;
    private javax.swing.JTable t_Invoice;
    private javax.swing.JTable t_InvoiceTotal;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Invoice> Invoces ;
    private Proj_Controller controller =  new Proj_Controller(this) ;
   private Invo_table Invo_table;
   
   
    public ArrayList<Invoice> getInvoces() {
                if (Invoces == null) Invoces = new ArrayList<>();

        return Invoces;
    }

    public void setInvoces(ArrayList<Invoice> Invoces) {
        this.Invoces = Invoces;
    }

    public Invo_table getInvo_table() {
      if (Invo_table == null) {
            Invo_table = new Invo_table(getInvoces());
        }
        return Invo_table;
    }

    public void setInvo_table(Invo_table Invo_table) {
        this.Invo_table = Invo_table;
    }

   

    public JTable getT_Invoice() {
        return t_Invoice;
    }

    public JTable getT_InvoiceTotal() {
        return t_InvoiceTotal;
    }

    public Proj_Controller getController() {
        return controller;
    }

    public javax.swing.JLabel getL_CustNAME() {
        return l_CustNAME;
    }

    public javax.swing.JLabel getL_InvoDATA() {
        return l_InvoDATA;
    }

    public javax.swing.JLabel getL_InvoNUM() {
        return l_InvoNUM;
    }

    public javax.swing.JLabel getL_InvoTOTAL() {
        return l_InvoTOTAL;
    }
public int getNextInvoNUM(){
    int num =0 ;
    
    for(Invoice invo : Invoces){
        if(invo.getNum() > num  )
            num = invo.getNum();
}
   
    return ++num;
    
}}
