
package com.salse.proj_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esraa
 */
public class Line_table extends AbstractTableModel{
    private ArrayList<Line> liness;
    private String[] colum= {"No" , "Name" , "Price" ,"Count", "Total"};

    public Line_table(ArrayList<Line> liness) {
        this.liness = liness;
    }

    public ArrayList<Line> getLines() {
        return liness;
    }
    
    
    @Override
    public int getRowCount() {
return liness.size();
    }

    @Override
    public int getColumnCount() {
return   colum.length;  }

    @Override
    public String getColumnName(int column_name) {
return colum[column_name] ;  }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Line line = liness.get(rowIndex);
        switch (columnIndex){
         //   case 0: return line.getInvoice().getNum();
            case 0: return line.getInvoice().getNum();
            case 1: return line.getItem();
            case 2: return line.getPrice();
            case 3: return line.getCount();
            case 4: return line.getTotal_line();
            default : return"";
    }
    
}}
