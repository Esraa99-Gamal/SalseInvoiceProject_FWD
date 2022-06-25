
package com.salse.proj_controller;
import com.salse.proj_model.Invo_table;
import com.salse.proj_model.Invoice;
import com.salse.proj_model.Line;
import com.salse.proj_model.Line_table;
import com.salse.proj_view.InvoDialog;
import com.salse.proj_view.InvoFrame;
import com.salse.proj_view.InvoLineDialog;
import java.*;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.list;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Proj_Controller implements ActionListener , ListSelectionListener{
   
    private InvoFrame frame;
    private InvoDialog invoDialog;
    private InvoLineDialog invoLineDialog;
    
    public Proj_Controller(InvoFrame frame){
    this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String actionCommand = e.getActionCommand();
        System.out.println("Action >> "+ actionCommand);
        switch(actionCommand){
            case "Load File":
                LoadFile();
                break;
            case "Save File":
                SaveFile();
                break;
            case "New Invoice":
                NewInvoice();
                break;
            case "Delete Invoice":
                DeleteInvoice();
                break;
            case "New Item":
                NewLine();
                break;
            case "Delete Item":
                DeleteLine();
                break;
            case "c_InvoiceCancel":
                c_InvoiceCancel();
                break;
            case "c_InvoiceAdd":
                c_InvoiceAdd();
                break;
                case"c_LineAdd":
                    c_LineAdd();
                    break;
                case "c_LineCancel":
                    c_LineCancel();
                    break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       int selectedRowNUM = frame.getT_Invoice().getSelectedRow();
       if(selectedRowNUM !=-1) {
       System.out.println("The row selected is "+selectedRowNUM);
         Invoice current_Invo = frame.getInvoces().get(selectedRowNUM);System.out.println("The row selected is "+selectedRowNUM);
         frame.getL_InvoNUM().setText(""+current_Invo.getNum());
         frame.getL_InvoDATA().setText(current_Invo.getDate());
         frame.getL_CustNAME().setText(current_Invo.getCustomer());
         frame.getL_InvoTOTAL().setText(""+current_Invo.getTotal_invo());
         
         Line_table l_table = new Line_table(current_Invo.getLines());
            frame.getT_InvoiceTotal().setModel(l_table);
            l_table.fireTableDataChanged();
    }
    }
    
    private void LoadFile() {
        JFileChooser fc = new JFileChooser();
        try{
              JOptionPane.showMessageDialog(frame, "Please, Select Invoice Header File","Information Message", JOptionPane.INFORMATION_MESSAGE);
        int result = fc.showOpenDialog(frame);
        if (result== JFileChooser.APPROVE_OPTION){
       File headerFile = fc.getSelectedFile();
       Path headerPath =Paths.get(headerFile.getAbsolutePath());
         List<String> headerLines = Files.readAllLines(headerPath);
             System.out.println("Invoces have been read");
           
             ArrayList<Invoice> invoArr = new ArrayList<>();
             for (String headerLine : headerLines){
                try { 
                 String[] partsOFheader = headerLine.split(",");
             
                 int invoiceID = Integer.parseInt(partsOFheader[0]);
             String invoiceDate = partsOFheader[1];
             String invoiceCustmoerName = partsOFheader[2];
             
             
            Invoice invo = new Invoice(invoiceID, invoiceDate, invoiceCustmoerName);
            invoArr.add(invo);
             }
                catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                        //Reminder to load only Line CSV file and error popup appear when try to choose fault file type
                    }
                }
             System.out.println("Check");
             JOptionPane.showMessageDialog(frame, "Please,Select Invoice Line File",  "Information Message", JOptionPane.INFORMATION_MESSAGE);
               
             result = fc.showOpenDialog(frame);
             if (result== JFileChooser.APPROVE_OPTION){
                 File lineFile = fc.getSelectedFile();
                 Path linePath =Paths.get(lineFile.getAbsolutePath());
                 List<String> lines = Files.readAllLines(linePath);
                   System.out.println("Lines have been read");
                  
                   
                   for (String Lines : lines){
                       try {
                       String partsOFline[] = Lines.split(",");
             int invoiceID = Integer.parseInt(partsOFline[0]);
             String itmeNAME = partsOFline[1];
             double itemPrice = Double.parseDouble(partsOFline[2]);
              int countOfitems = Integer.parseInt(partsOFline[3]) ;
                  Invoice invo = null;
                  for (Invoice invoice : invoArr ){
                  if(invoice.getNum() == invoiceID){
                      invo = invoice;
                      break;
                  }
                  }
                 Line line = new Line( itmeNAME, itemPrice, countOfitems, invo);
                 invo.getLines().add(line);
                 
                   }
                       catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(frame, "Invalid line format", "Error", JOptionPane.ERROR_MESSAGE);
                    
                        }
                   System.out.println("Check 2");
                 }
                 frame.setInvoces(invoArr);
                 Invo_table Invo_table = new Invo_table(invoArr);
                 frame.setInvo_table(Invo_table);
                 frame.getT_Invoice().setModel(Invo_table);
                 frame.getInvo_table().fireTableDataChanged();
                 
             }
           }
        } catch(IOException ex){
               ex.printStackTrace();
               JOptionPane.showMessageDialog(frame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }

    private void SaveFile() {
        ArrayList<Invoice> invoices = frame.getInvoces();
        String invo_head = "";
        String lines = "";
        for (Invoice invo : invoices) {
            String invFile = invo.getAsCSVFile();
            invo_head += invFile;
            invo_head += "\n";

            for (Line L : invo.getLines()) {
                String lineFile = L.getAsCSVFile();
                lines += lineFile;
                lines += "\n";
            }
        }
        System.out.println("Check point");
        
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File head_File = fc.getSelectedFile();
                FileWriter H = new FileWriter(head_File);
                H.write(invo_head);
                H.flush();
                H.close();
                result = fc.showSaveDialog(frame);
                JOptionPane.showMessageDialog(frame, "File saved successfully",
           "Information Message", JOptionPane.INFORMATION_MESSAGE);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter L = new FileWriter(lineFile);
                    L.write(lines);
                    L.flush();
                    L.close();
                }
            }
        } catch (Exception ex) {
            

        }
        }

    private void NewInvoice() {
        invoDialog = new InvoDialog(frame);
        invoDialog.setVisible(true);
    }

    private void DeleteInvoice() {
       int selected_Row = frame.getT_Invoice().getSelectedRow();
        if (selected_Row != -1){
            frame.getInvoces().remove(selected_Row);
            frame.getInvo_table().fireTableDataChanged();
            
        }
        
    }

    private void NewLine() {
        invoLineDialog = new InvoLineDialog(frame);
        invoLineDialog.setVisible(true);
    }

    private void DeleteLine() {
        int selected_invo = frame.getT_Invoice().getSelectedRow();
        int selected_Row = frame.getT_InvoiceTotal().getSelectedRow();
        if (selected_Row != -1 && selected_invo != -1 ){
            Invoice invo = frame.getInvoces().get(selected_invo);
            invo.getLines().remove(selected_Row);
           Line_table line_table = new Line_table(invo.getLines());
           frame.getT_InvoiceTotal().setModel(line_table);
           line_table.fireTableDataChanged();
    }

    }

    private void c_InvoiceCancel() {
        invoDialog.setVisible(false);
        invoDialog.dispose();
        invoDialog= null;
    }

    private void c_InvoiceAdd() {
        String date = invoDialog.getInvDateField().getText();
        String customer = invoDialog.getCustNameField().getText();
        int num = frame.getNextInvoNUM();
      
        try {
            String[] partsOFdate = date.split("-");
            if (partsOFdate.length < 3) {
                JOptionPane.showMessageDialog(frame, "Invalid date format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int day = Integer.parseInt(partsOFdate[0]);
                int month = Integer.parseInt(partsOFdate[1]);
                int year = Integer.parseInt(partsOFdate[2]);
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(frame, "Invalid date format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
      Invoice invo = new Invoice(num,date,customer);
      frame.getInvoces().add(invo);
      frame.getInvo_table().fireTableDataChanged();
      invoDialog.setVisible(false);
                    invoDialog.dispose();
                    invoDialog = null;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid date format", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void c_LineAdd() {
        String item = invoLineDialog.getItemNameField().getText();
        String countStr = invoLineDialog.getItemCountField().getText();
        String priceStr = invoLineDialog.getItemPriceField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getT_Invoice().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invo = frame.getInvoces().get(selectedInvoice);
            Line L = new Line(item, price, count, invo);
            invo.getLines().add(L);
            Line_table line_table = (Line_table) frame.getT_InvoiceTotal().getModel();
            line_table.fireTableDataChanged();
            frame.getInvo_table().fireTableDataChanged();
        }
        invoLineDialog.setVisible(false);
        invoLineDialog.dispose();
        invoLineDialog = null;
   }

    private void c_LineCancel() {
        invoLineDialog.setVisible(false);
        invoLineDialog.dispose();
        invoLineDialog = null;
    }
    
}
