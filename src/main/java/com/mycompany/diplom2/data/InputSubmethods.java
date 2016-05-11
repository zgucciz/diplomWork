/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author 1
 */
@DatabaseTable(tableName = "InputSubmethods")
public class InputSubmethods {
    
    public static InputSubmethods NONE_SELECTED = new InputSubmethods(null,"<Выбрать>",null);
    @DatabaseField(columnName = "Key", foreign = true)
    InputMethods method;
    
    @DatabaseField(columnName = "Submethods")
    String submethod;
    
    @DatabaseField(columnName = "Examples")
    String examples;

    public InputSubmethods() {
        this.method = null;
        this.submethod = "";
        this.examples = "";
    }

    public InputSubmethods(InputMethods method, String submethods, String examples) {
        this.method = method;
        this.submethod = submethods;
        this.examples = examples;
    }

    public InputMethods getMethod() {
        return method;
    }

    public String getSubmethod() {
        return submethod;
    }

    public String getExamples() {
        return examples;
    }

    public void setMethod(InputMethods method) {
        this.method = method;
    }

    public void setSubmethod(String submethod) {
        this.submethod = submethod;
    }

    public void setExamples(String examples) {
        this.examples = examples;
    }
    
    @Override
    public String toString() {
        return submethod;
    }
    
}
