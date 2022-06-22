


package com.salse.model;

import java.util.ArrayList;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;


public class Invo_table extends AbstractTableModel {
    private ArrayList<Invoice> Invoces ; 
private String[] colum= {"No" , "Date" , "Customer" , "Total"};
    public Invo_table(ArrayList<Invoice> Invoces) {
        this.Invoces = Invoces;
    }

    
    @Override
    public int getRowCount() {
        return Invoces.size();
    }

    @Override
    public int getColumnCount() {
        return colum.length;
    }

    @Override
    public String getColumnName(int column_name) {
        return colum[column_name];
    }


    public String[] getColum() {
        return colum;
    }

    public void setColum(String[] colum) {
        this.colum = colum;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
        Invoice invoice = Invoces.get(rowIndex); 
        switch (columnIndex){
            case 0: return invoice.getNum();
            case 1: return invoice.getDate();
            case 2: return invoice.getCustomer();
            case 3: return invoice.getTotal_invo();
            default : return"";
                
        }
    }

    
}
