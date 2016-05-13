/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data.GUI.extraWindows;

import com.mycompany.diplom2.data.DataService;
import com.mycompany.diplom2.data.GUI.ChooseSetOfSensors;
import com.mycompany.diplom2.data.ItemsOfSetOfSensors;
import com.mycompany.diplom2.data.Sensors;
import com.mycompany.diplom2.data.SetOfSensors;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author 1
 */
public class newSetFrame extends javax.swing.JFrame {

    /**
     * Creates new form newSetFrame
     */
    Sensors[] allSensors, choosenSensors;
    Boolean[] selection;
    
    public newSetFrame() throws SQLException {
        initComponents();
        backButton.setVisible(false);
        DataService<Sensors> ds = new DataService(Sensors.class);
        allSensors = ds.getAllAsArray();
        int countRow = allSensors.length;
        selection = new Boolean[countRow];
        for(int i =0; i<countRow; i++) selection[i] = false;
        formChooseSensorTable();
        newSensorFrame.setLocationRelativeTo(null);
        newSensorFrame.setTitle("Новый Сенсор");
        
    }

    //функция заполняет таблицу сенсорами для выбора нужных в набор
    public void formChooseSensorTable(){
        
             //так не реагирует на клик по checkBox

//        ArrayList<Object[]> list = new ArrayList<Object[]>();
//        list.add(allSensors);
//        list.add(selection);
//        String[] columnNames = {"Сенсор","Выбрать"};
//        Class[] types = {Sensors.class,Boolean.class};
//        Boolean[] canEdit = {false, true};
//        TableModel tm = new CustomTableModel<Sensors>(list, columnNames, types, canEdit);
//        chooseTable.setModel(tm);
        
 // так работает хорошо
        chooseTable.setModel(new javax.swing.table.DefaultTableModel() {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ((DefaultTableModel)chooseTable.getModel()).addColumn("Сенсор", allSensors);
        ((DefaultTableModel)chooseTable.getModel()).addColumn("Выбрать", selection);
    }
    
    //функция заполняет таблицу выбранными сенсорами для формирования порядка
    public void formOfSequenceTable(){
        chooseTable.setModel(new javax.swing.table.DefaultTableModel() {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        int chooseCount = choosenSensors.length;  //количество выбранных сенсоров
        Object[] nums = new Object[chooseCount];  //массив объектов от 1 до chooseCount 
        for(int i = 0; i<chooseCount; i++)
            nums[i] = i+1;
        JComboBox seq = new JComboBox(nums);
        
        
        seq.addItemListener(new java.awt.event.ItemListener() {
            Object lastDeselected = new Object();
            
            // фенкция контролирует, чтобы не было сенсоров с одинаковыми номерами
            public void killCopy(Object el){
                int rowCount = chooseTable.getRowCount();
                for(int i=0; i < rowCount; i++)
                    if(i != chooseTable.getSelectedRow())
                        if(el.equals(chooseTable.getModel().getValueAt(i, 1)))
                            chooseTable.setValueAt(lastDeselected, i, 1);
                
            }

            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED)
                    lastDeselected = e.getItem();
                else
                    killCopy(e.getItem());
//                System.out.println(e.paramString());
            }
        });
        

        
        ((DefaultTableModel)chooseTable.getModel()).addColumn("Сенсор", choosenSensors);
        ((DefaultTableModel)chooseTable.getModel()).addColumn("Порядковый номер",nums);
        
        TableColumn column;
        column = chooseTable.getColumnModel().getColumn(1);
        column.setCellEditor(new DefaultCellEditor(seq));
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

        newSensorFrame = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        sensorFullNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sensorShortNameField = new javax.swing.JTextField();
        addSensorButton = new javax.swing.JButton();
        tableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chooseTable = new javax.swing.JTable();
        setNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        performButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        addNewSensorButton = new javax.swing.JButton();
        deleteCeckedSensorsButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        newSensorFrame.setMinimumSize(new java.awt.Dimension(330, 220));
        newSensorFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Введите полное название");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 38, 0, 0);
        newSensorFrame.getContentPane().add(jLabel2, gridBagConstraints);

        sensorFullNameField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 287;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        newSensorFrame.getContentPane().add(sensorFullNameField, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Введите краткое наименование");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 10);
        newSensorFrame.getContentPane().add(jLabel3, gridBagConstraints);

        sensorShortNameField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 287;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        newSensorFrame.getContentPane().add(sensorShortNameField, gridBagConstraints);

        addSensorButton.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        addSensorButton.setText("Добавить");
        addSensorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSensorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 174;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 11, 10);
        newSensorFrame.getContentPane().add(addSensorButton, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 310));
        setPreferredSize(new java.awt.Dimension(655, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tableTitle.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        tableTitle.setText("Выбор сенсоров в массив:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        getContentPane().add(tableTitle, gridBagConstraints);

        chooseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(chooseTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 323;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        setNameField.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        setNameField.setText("Новый набор");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 361;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 2, 0, 10);
        getContentPane().add(setNameField, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Имя набора");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        performButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        performButton.setText("Далее");
        performButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(17, 10, 11, 0);
        getContentPane().add(performButton, gridBagConstraints);

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("<html>\nК выбору сенсоров");
        backButton.setToolTipText("");
        backButton.setMinimumSize(new java.awt.Dimension(117, 50));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(backButton, gridBagConstraints);

        addNewSensorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addNewSensorButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\1\\Documents\\NetBeansProjects\\Diplom2\\src\\icons\\add_60x60.png")); // NOI18N
        addNewSensorButton.setToolTipText("Добавит сенсор в БД");
        addNewSensorButton.setMinimumSize(new java.awt.Dimension(60, 60));
        addNewSensorButton.setPreferredSize(new java.awt.Dimension(60, 60));
        addNewSensorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSensorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(addNewSensorButton, gridBagConstraints);

        deleteCeckedSensorsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\1\\Documents\\NetBeansProjects\\Diplom2\\src\\icons\\Delete_60x60.png")); // NOI18N
        deleteCeckedSensorsButton.setToolTipText("Удалить отмеченные сенсоры");
        deleteCeckedSensorsButton.setMinimumSize(new java.awt.Dimension(60, 60));
        deleteCeckedSensorsButton.setPreferredSize(new java.awt.Dimension(60, 60));
        deleteCeckedSensorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCeckedSensorsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(deleteCeckedSensorsButton, gridBagConstraints);

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setLabel("<html>\nОтмена<br>создания");
        cancelButton.setMinimumSize(new java.awt.Dimension(117, 50));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(cancelButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void performButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performButtonActionPerformed
        // TODO add your handling code here:
        if(performButton.getText().equals("Далее")){
            int rowCount = selection.length, chooseCount = 0; 
            for(int i = 0; i< rowCount; i++){
                selection[i] = (Boolean)((DefaultTableModel)chooseTable.getModel()).getValueAt(i, 1);
                if(selection[i]) chooseCount++;
            } 
            if(chooseCount == 0) JOptionPane.showMessageDialog(this, 
                                                            "Не выбрано ни одного сенсора для набора!", 
                                                            "Ошибка", 
                                                            JOptionPane.ERROR_MESSAGE);
            else{
                backButton.setVisible(true);
                choosenSensors = new Sensors[chooseCount];
                for(int i = 0, k = 0; i< chooseCount; i++, k++){
                    while(!selection[k]) k++;
                    choosenSensors[i] = allSensors[k];
                } 
                formOfSequenceTable();
                addNewSensorButton.setVisible(false);
                deleteCeckedSensorsButton.setVisible(false);
                tableTitle.setText("Формирование порядка в массиве:");
                performButton.setText("Готово");
            }
        }else{
            if(setNameField.getText().trim().isEmpty())JOptionPane.showMessageDialog(this, 
                                                            "Поле с именем набора не должно быть пустым!", 
                                                            "Ошибка", 
                                                            JOptionPane.ERROR_MESSAGE);
            else{
                int option = JOptionPane.showConfirmDialog(newSensorFrame, 
                                      "Вы уверены, что хотите создать набор "+setNameField.getText().trim()+"с установленнвми параметрами ?",
                                      "Подтвердите действие",
                                      JOptionPane.YES_NO_CANCEL_OPTION , 
                                      JOptionPane.QUESTION_MESSAGE);
                if(option == JOptionPane.YES_OPTION){
                    String newSetName = setNameField.getText().trim();
                    SetOfSensors newSet = new SetOfSensors(newSetName);
                    try {
                        DataService<SetOfSensors> setDS = new DataService(SetOfSensors.class);
                        setDS.create(newSet);
                        int itemsCount = chooseTable.getRowCount();
                        DataService<ItemsOfSetOfSensors> itemsDS = new DataService(ItemsOfSetOfSensors.class);
                        ItemsOfSetOfSensors el;
                        Sensors[] items = new Sensors[itemsCount];
                        for(int i=0, k=0; i<itemsCount; i++, k=0){
                            while(!chooseTable.getModel().getValueAt(k, 1).equals(i+1))
                                k++;
                            items[i] = (Sensors) chooseTable.getModel().getValueAt(k, 0);
                            el = new ItemsOfSetOfSensors(newSet,Integer.toString(items[i].getSensorId()));
                            itemsDS.create(el);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(newSetFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(newSensorFrame,
                                          "Набор "+setNameField.getText().trim()+" с установленнвми параметрами создан успешно!",
                                          "Сообщение",
                                          JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    ChooseSetOfSensors.run();
                } 
            }
        }
    }//GEN-LAST:event_performButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        formChooseSensorTable();
        tableTitle.setText("Выбор сенсоров в массив:");
        performButton.setText("Далее");
        addNewSensorButton.setVisible(true);
        deleteCeckedSensorsButton.setVisible(true);
        backButton.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addNewSensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSensorButtonActionPerformed
        // TODO add your handling code here:
        newSensorFrame.setVisible(true);
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_addNewSensorButtonActionPerformed

    private void addSensorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSensorButtonActionPerformed
        // TODO add your handling code here:
        String sensorFullName = sensorFullNameField.getText(),
               sensorShortName = sensorShortNameField.getText();
        int option = JOptionPane.showConfirmDialog(newSensorFrame, 
                                      "Вы уверены, что хотите добавить сенсор: "+sensorFullName+" ("+sensorShortName+") ?",
                                      "Подтвердите действие",
                                      JOptionPane.YES_NO_CANCEL_OPTION , 
                                      JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            Sensors newSensor = new Sensors(sensorFullName, sensorShortName); 
            try {
                DataService<Sensors> ds = new DataService(Sensors.class);
                ds.create(newSensor);
                allSensors = ds.getAllAsArray();
            } catch (SQLException ex) {
                Logger.getLogger(newSetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            newSensorFrame.setVisible(false);
            int countRow = allSensors.length;
            Boolean[] newSelection = new Boolean[countRow];
            for(int i =0; i<countRow-1; i++) newSelection[i] = selection[i];
            newSelection[countRow-1] = false;
            selection = newSelection;
            formChooseSensorTable();
            this.setState(JFrame.NORMAL);
            JOptionPane.showMessageDialog(newSensorFrame,
                                          "Сенсор "+sensorFullName+" ("+sensorShortName+") добавлен успешно!",
                                          "Сообщение",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addSensorButtonActionPerformed

    private void deleteCeckedSensorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCeckedSensorsButtonActionPerformed
        // TODO add your handling code here:
        int rowCount = selection.length, chooseCount = 0; 
            for(int i = 0; i< rowCount; i++){
                selection[i] = (Boolean)((DefaultTableModel)chooseTable.getModel()).getValueAt(i, 1);
                if(selection[i]) chooseCount++;
            } 
            choosenSensors = new Sensors[chooseCount];
            for(int i = 0, k = 0; i< chooseCount; i++, k++){
                while(!selection[k]) k++;
                choosenSensors[i] = allSensors[k];
            } 
        if(chooseCount == 0) JOptionPane.showMessageDialog(this, 
                                                            "Не выбрано ни одного сенсора для удаления!", 
                                                            "Ошибка удаления", 
                                                            JOptionPane.ERROR_MESSAGE);
        else{
            String message = "Вы уверены, что хотите удалить следующие "+chooseCount+" сенсоров: \n";
            for(int i=0; i<chooseCount-1; i++)
                message+=choosenSensors[i]+",\n";
            int option = JOptionPane.showConfirmDialog(this, 
                                      message+choosenSensors[chooseCount-1]+" ?",
                                      "Подтвердите действие",
                                      JOptionPane.YES_NO_CANCEL_OPTION , 
                                      JOptionPane.QUESTION_MESSAGE);
        if(option == JOptionPane.YES_OPTION){
            try {
                DataService<Sensors> ds = new DataService(Sensors.class);
                for(int i=0; i<chooseCount; i++)
                    ds.delete(choosenSensors[i]);
                allSensors = ds.getAllAsArray();
            } catch (SQLException ex) {
                Logger.getLogger(newSetFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            int countRow = allSensors.length;
            selection = new Boolean[countRow];
            for(int i =0; i<countRow-1; i++) 
                selection[i] = false;
            formChooseSensorTable();
            JOptionPane.showMessageDialog(newSensorFrame,
                                          "Удаление успешно выполнено!",
                                          "Сообщение",
                                          JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }//GEN-LAST:event_deleteCeckedSensorsButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ChooseSetOfSensors.run();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    public static void run() throws SQLException {
        newSetFrame fr = new newSetFrame();
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewSensorButton;
    private javax.swing.JButton addSensorButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable chooseTable;
    private javax.swing.JButton deleteCeckedSensorsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFrame newSensorFrame;
    private javax.swing.JButton performButton;
    private javax.swing.JTextField sensorFullNameField;
    private javax.swing.JTextField sensorShortNameField;
    private javax.swing.JTextField setNameField;
    private javax.swing.JLabel tableTitle;
    // End of variables declaration//GEN-END:variables
}
