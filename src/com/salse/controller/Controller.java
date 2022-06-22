/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salse.controller;
import com.salse.model.Invo_table;
import com.salse.model.Invoice;
import com.salse.model.Line;
import com.salse.model.Line_table;
import com.salse.view.InvoiceFrame;
import java.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.list;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Controller implements ActionListener , ListSelectionListener{
   
    private InvoiceFrame frame;
    
    public Controller(InvoiceFrame frame){
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
                NewItem();
                break;
            case "Delete Item":
                DeleteFile();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       int selectedRowNUM = frame.getT_Invoice().getSelectedRow();
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
    
    
    private void LoadFile() {
        JFileChooser fc = new JFileChooser();
        try{
        int result = fc.showOpenDialog(frame);
        if (result== JFileChooser.APPROVE_OPTION){
       File headerFile = fc.getSelectedFile();
       Path headerPath =Paths.get(headerFile.getAbsolutePath());
                //There was an error ,it not solved until writing this lind below
                  java.util.List<String> headerLines = Files.readAllLines(headerPath);
             System.out.println("Invoces have been read");
            
             
             ArrayList<Invoice> invoArr = new ArrayList<>();
             for (String headerLine : headerLines){
                 
                 String[] partsOFheader = headerLine.split(",");
                 //String[] partsOFheader = headerLines.split(",");
             
                 int invoiceID = Integer.parseInt(partsOFheader[0]);
             String invoiceDate = partsOFheader[1];
             String invoiceCustmoerName = partsOFheader[2];
             
             
            Invoice invo = new Invoice(invoiceID, invoiceDate, invoiceCustmoerName);
            invoArr.add(invo);
             }
             System.out.println("Check");
            
             
             result = fc.showOpenDialog(frame);
             if (result== JFileChooser.APPROVE_OPTION){
                 File lineFile = fc.getSelectedFile();
                 Path linePath =Paths.get(lineFile.getAbsolutePath());
                 java.util.List<String> lines = Files.readAllLines(linePath);
                   System.out.println("Lines have been read");
                  
                   
                   for (String Lines : lines){
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
                   System.out.println("Check 2");
                 }
                 frame.setInvoces(invoArr);
                 Invo_table Invo_table = new Invo_table(invoArr);
                 frame.setInvo_table(Invo_table);
                // frame.getInvo_table().
                 frame.getT_Invoice().setModel(Invo_table);
                 frame.getInvo_table().fireTableDataChanged();
                 
        }
           } catch(IOException ex){
               ex.printStackTrace();
            }
        }

    private void SaveFile() {
        
        }

    private void NewInvoice() {
        
    }

    private void DeleteInvoice() {
        
    }

    private void NewItem() {
        
    }

    private void DeleteFile() {
        
    }

    
    
}
