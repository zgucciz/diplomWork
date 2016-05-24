/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data.GUI;

import com.j256.ormlite.dao.ForeignCollection;
import com.mycompany.diplom2.data.DataService;
import com.mycompany.diplom2.data.GUI.extraWindows.newSetFrame;
import com.mycompany.diplom2.data.ItemsOfSetOfSensors;
import com.mycompany.diplom2.data.Sensors;
import com.mycompany.diplom2.data.SetOfSensors;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author 1
 */
public class ChooseSetOfSensors extends javax.swing.JFrame {

    /**
     * Creates new form ChooseSetOfSensors
     */
    public ChooseSetOfSensors() {
        initComponents();
        formSetTable();
    }
    
    public void formSetTable(){
        changeSetButton.setEnabled(false);
        deleteSetButton.setEnabled(false);
        readyButton.setEnabled(false);
        
        tableOfSets.setSelectionMode(NORMAL);
//        setColumnsWidth(ContentOfTheSet);
        try {
            DataService<SetOfSensors> ds;
            ds = new DataService(SetOfSensors.class);
            SetOfSensors allSets[] = ds.getAllAsArray();
//            ArrayList<Object[]> allItems = new ArrayList<Object[]>();
            int countOfSets = allSets.length; 
            if(countOfSets == 0){
                String[] columnNames = {"Имя набора"};
                String[] emptySet = {"Нет наборов сенсоров"};
//                allItems.add(emptySet);
//                TableModel tm = new CustomTableModel<String>(allItems, columnNames);
//                tableOfSets.setModel(tm);
                
                DefaultTableModel tm = new DefaultTableModel();
                tableOfSets.setModel(tm);
                tm.addColumn(columnNames[0], emptySet);
                
                tableOfSets.setEnabled(false);
            }
            else{
            //тут заполняю таблицу наборами и леплю листенер
                String[] columnNames = {"Имя набора"};
//                allItems.add(allSets);
//                TableModel tm = new CustomTableModel<SetOfSensors>(allItems, columnNames);
//                tableOfSets.setModel(tm);
                
                DefaultTableModel tm = new DefaultTableModel();
                tableOfSets.setModel(tm);
                tm.addColumn(columnNames[0], allSets);
                
                tableOfSets.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent e) {
                        if(tableOfSets.getSelectedRowCount() != 0)
                            try {
                                String[] columnNames = {"Имя сенсора", "№"};
                                SetOfSensors el =(SetOfSensors) tableOfSets.getModel().getValueAt(tableOfSets.getSelectedRow(), 0);
//                                ArrayList<Object[]> allItems = new ArrayList<Object[]>();
                                Sensors[] set = el.getSetAsArray();
//                                allItems.add(set);
                                int countOfSensors = set.length;
                                String[] nums = new String[countOfSensors];
                                for(int i = 0; i<countOfSensors;i++)
                                    nums[i] = Integer.toString(i+1);
//                                allItems.add(nums);
//                                TableModel tm = new CustomTableModel<Sensors>(allItems, columnNames);
//                                contentOfTheSet.setModel(tm);
//    //                            setColumnsWidth(ContentOfTheSet);
                                
                                DefaultTableModel tm = new DefaultTableModel();
                                contentOfTheSet.setModel(tm);
                                tm.addColumn(columnNames[0], set);
                                tm.addColumn(columnNames[1], nums);
                                
                                changeSetButton.setEnabled(true);
                                deleteSetButton.setEnabled(true);
                                readyButton.setEnabled(true);
                            } catch (SQLException ex) {
                                Logger.getLogger(ChooseSetOfSensors.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChooseSetOfSensors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tableOfSets = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        contentOfTheSet = new javax.swing.JTable();
        newSetButton = new javax.swing.JButton();
        changeSetButton = new javax.swing.JButton();
        deleteSetButton = new javax.swing.JButton();
        readyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(560, 300));
        setPreferredSize(new java.awt.Dimension(700, 400));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        tableOfSets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Имя набора"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableOfSets);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 309;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 14, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        contentOfTheSet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Имя сенсора", "№"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contentOfTheSet.setAutoscrolls(false);
        contentOfTheSet.setEnabled(false);
        contentOfTheSet.setFocusable(false);
        jScrollPane2.setViewportView(contentOfTheSet);
        contentOfTheSet.getColumnModel().getColumn(1).setResizable(false);
        contentOfTheSet.getColumnModel().getColumn(1).setPreferredWidth(50);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 309;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_TRAILING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 14, 10);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        newSetButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        newSetButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\1\\Documents\\NetBeansProjects\\Diplom2\\src\\icons\\add_60x60.png")); // NOI18N
        newSetButton.setToolTipText("Создать новый набор");
        newSetButton.setMinimumSize(new java.awt.Dimension(60, 60));
        newSetButton.setPreferredSize(new java.awt.Dimension(60, 60));
        newSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(newSetButton, gridBagConstraints);

        changeSetButton.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        changeSetButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\1\\Documents\\NetBeansProjects\\Diplom2\\src\\icons\\edit_60x60.png")); // NOI18N
        changeSetButton.setToolTipText("Изменить выбранный набор");
        changeSetButton.setEnabled(false);
        changeSetButton.setMinimumSize(new java.awt.Dimension(60, 60));
        changeSetButton.setPreferredSize(new java.awt.Dimension(60, 60));
        changeSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        getContentPane().add(changeSetButton, gridBagConstraints);

        deleteSetButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\1\\Documents\\NetBeansProjects\\Diplom2\\src\\icons\\Delete_60x60.png")); // NOI18N
        deleteSetButton.setToolTipText("Удалить выбранный набор");
        deleteSetButton.setEnabled(false);
        deleteSetButton.setMinimumSize(new java.awt.Dimension(60, 60));
        deleteSetButton.setPreferredSize(new java.awt.Dimension(60, 60));
        deleteSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        getContentPane().add(deleteSetButton, gridBagConstraints);

        readyButton.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        readyButton.setText("Готово");
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        getContentPane().add(readyButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSetButtonActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            newSetFrame.run();
        } catch (SQLException ex) {
            Logger.getLogger(ChooseSetOfSensors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newSetButtonActionPerformed

    private void deleteSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSetButtonActionPerformed
        // TODO add your handling code here:
        SetOfSensors el =(SetOfSensors) tableOfSets.getModel().getValueAt(tableOfSets.getSelectedRow(), 0);
        int option = JOptionPane.showConfirmDialog(this, 
                                      "Вы уверены, что хотите удалить набор "+el.getNameOfSet()+" ?",
                                      "Подтвердите действие",
                                      JOptionPane.YES_NO_OPTION , 
                                      JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            try {
                DataService<SetOfSensors> SetDS = new DataService(SetOfSensors.class);
                DataService<ItemsOfSetOfSensors> ItemsDS = new DataService(ItemsOfSetOfSensors.class);
                ForeignCollection<ItemsOfSetOfSensors> itemsCollection = el.getSensorsOfSet();
                ItemsDS.deleteByValue("idOfSet", el.getidOfSet());
                SetDS.delete(el);
                ((DefaultTableModel)contentOfTheSet.getModel()).setRowCount(0);
                formSetTable();
                JOptionPane.showMessageDialog(this,
                                             "Удаление успешно выполнено!",
                                             "Сообщение",
                                             JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(newSetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteSetButtonActionPerformed

    private void changeSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSetButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,
                                             "Вам лучше сейчас нажать на другую кнопку...",
                                             "Сообщение",
                                             JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_changeSetButtonActionPerformed

    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        SetOfSensors el =(SetOfSensors) tableOfSets.getModel().getValueAt(tableOfSets.getSelectedRow(), 0);
        EnterValuesOfSensorsReactions.run(el);
    }//GEN-LAST:event_readyButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    public void setColumnsWidth(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader th = table.getTableHeader();
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int prefWidth = (i == 0? table.getWidth()-40 : 40);
            column.setPreferredWidth(prefWidth);
        }
   }
    
      public static void run(){
        ChooseSetOfSensors form = new ChooseSetOfSensors();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeSetButton;
    private javax.swing.JTable contentOfTheSet;
    private javax.swing.JButton deleteSetButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newSetButton;
    private javax.swing.JButton readyButton;
    private javax.swing.JTable tableOfSets;
    // End of variables declaration//GEN-END:variables
}
