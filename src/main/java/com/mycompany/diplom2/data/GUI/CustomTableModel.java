/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data.GUI;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author 1
 */
public class CustomTableModel<T> extends AbstractTableModel {
    
    ArrayList<Object[]> allItems;
    String[] columnNames;
    
       //experiments 
    
    Class[] types ;
    Boolean[] canEdit ;
    
    public CustomTableModel(ArrayList<Object[]> allItems, String[] columnNames, Class[] types, Boolean[] canEdit){
        super();
        this.columnNames = columnNames;
        this.allItems = allItems;
        this.types = types;
        this.canEdit = canEdit;
    }
    
    public CustomTableModel(ArrayList<Object[]> allItems, String[] columnNames, Class[] types){
        super();
        int columnCount = columnNames.length;
        Boolean[] canEdit = new Boolean[columnCount];
        for(int i = 0; i< columnCount; i++) canEdit[i] = true;
        this.columnNames = columnNames;
        this.allItems = allItems;
        this.types = types;
        this.canEdit = canEdit;
    }
    public CustomTableModel(ArrayList<Object[]> allItems, String[] columnNames){
        super();
        int columnCount = columnNames.length;
        Boolean[] canEdit = new Boolean[columnCount];
        Class[] types = new Class[columnCount];
        for(int i = 0; i< columnCount; i++) {
            canEdit[i] = true;
            types[i] = Object.class;
        }
        this.columnNames = columnNames;
        this.allItems = allItems;
        this.types = types;
        this.canEdit = canEdit;
    }
//    public CustomTableModel(ArrayList<Object[]> allItems, String[] columnNames, Class[] types){
//        super();
//        this.columnNames = columnNames;
//        this.allItems = allItems;
//        this.types = types;
//    }
//        //end of experiments
//    
//    public CustomTableModel(ArrayList<Object[]> allItems, String[] columnNames){
//        super();
//        this.columnNames = columnNames;
//        this.allItems = allItems;
//    }
    @Override
    public int getRowCount() {
        return allItems.get(0).length;
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int c) {
        return columnNames[c];
    }
    @Override
    public Object getValueAt(int r, int c) {
        return allItems.get(c)[r];
    }
    

   //experiments 
    


    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }


}
