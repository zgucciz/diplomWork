/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data.GUI;

import com.mycompany.diplom2.data.InputMethods;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author 1
 */
public class CustomListModel<T> extends DefaultComboBoxModel<T> {

    
    public CustomListModel(T[] items) {
        super(items);
    }

    public T getSelectedItem() {
        return (T) super.getSelectedItem();
    }
    
    public void setSelectedItem(Object item){
        super.setSelectedItem(item);
    }
    
}