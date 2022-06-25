
package com.salse.proj_model;

/**
 *
 * @author esraa
 */
import com.salse.proj_model.Invoice;
import com.salse.proj_model.Line;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileOperation {
      private ArrayList<Invoice> invoiceH;
      
    public ArrayList<Invoice> read(){
        
        
        JFileChooser fc = new JFileChooser();

        try {
            JOptionPane.showMessageDialog(null, "Select Invoice Header File",
               "Invoice Header", JOptionPane.INFORMATION_MESSAGE);
            int result = fc.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File header_File = fc.getSelectedFile();
                Path headerPath = Paths.get(header_File.getAbsolutePath());
                List<String> header_Lines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");
                
                ArrayList<Invoice> invoicesArray = new ArrayList<>();
                for (String header_Line : header_Lines) {
                    try {
                        String[] PartsOfheader = header_Line.split(",");
                        int invoiceNum = Integer.parseInt(PartsOfheader[0]);
                        String invoiceDate = PartsOfheader[1];
                        String customerName = PartsOfheader[2];

                        Invoice invo = new Invoice(invoiceNum, invoiceDate, customerName);
                        invoicesArray.add(invo);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                System.out.println("Check point");
                JOptionPane.showMessageDialog(null, "Select Invoice Line File",
                        "Invoice Line", JOptionPane.INFORMATION_MESSAGE);
                result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File line_File = fc.getSelectedFile();
                    Path line_Path = Paths.get(line_File.getAbsolutePath());
                    List<String> lineL = Files.readAllLines(line_Path);
                    System.out.println("Lines have been read");
                    for (String lineLine : lineL) {
                        try {
                            String lineParts[] = lineLine.split(",");
                            int invoiceNum = Integer.parseInt(lineParts[0]);
                            String itemName = lineParts[1];
                            double itemPrice = Double.parseDouble(lineParts[2]);
                            int count = Integer.parseInt(lineParts[3]);
                            Invoice inv = null;
                            for (Invoice invoice : invoicesArray) {
                                if (invoice.getNum() == invoiceNum) {
                                    inv = invoice;
                                    break;
                                }
                            }

                            Line line = new Line(itemName, itemPrice, count, inv);
                            inv.getLines().add(line);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                                //Reminder to load only CSV file and error popup appear when try to choose fault file type
                           }
                        }
                    
                    System.out.println("Check point");
                    
                  }
              
                this.invoiceH = invoicesArray;  // store invoices array in the class variable
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        return invoiceH;
    }
    
    
    
    
    
    public void write(ArrayList<Invoice> invoices)
    {
        for(Invoice invo : invoices)
      {
          int inv_ID = invo.getNum();
          String date = invo.getDate();
          String customer = invo.getCustomer();
          System.out.println("\n Invice " + inv_ID + "\n {\n " + date + "," + customer);
          ArrayList<Line> lines = invo.getLines();
          for(Line L : lines)
          {
              System.out.println( L.getItem() + "," + L.getPrice() + "," + L.getCount());
          }
          
          System.out.println(" } \n");
      }
        
    }
    
    
    
    
    
     public static void main(String[] args)
   {
       FileOperation fo = new FileOperation();
       ArrayList<Invoice> invoices = fo.read();
       fo.write(invoices);
              
   }
    
  
    
}
