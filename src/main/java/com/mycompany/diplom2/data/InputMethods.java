/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.lang.reflect.Array;
import java.util.Iterator;

/**
 *
 * @author 1
 */
@DatabaseTable(tableName = "InputMethods")
public class InputMethods {

    public static InputMethods NONE_SELECTED = new InputMethods("<Выбрать>", Integer.MAX_VALUE);
    @DatabaseField(columnName = "methods")
    private String methods;
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;
    @ForeignCollectionField
    private ForeignCollection<InputSubmethods> submethods;

    public InputMethods() {
        this.methods = "";
    }

    public InputMethods(String methods, int id) {
        this.methods = methods;
        this.id = id;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethods() {
        return methods;
    }

    public int getId() {
        return id;
    }

    public InputSubmethods[] getSubmethodsAsArray() {
        InputSubmethods sm[];
        sm = (InputSubmethods[])Array.newInstance(InputSubmethods.class, submethods.size());
        int i = 0;        
        for (Iterator<InputSubmethods> it = submethods.iterator(); it.hasNext(); i++) {
            sm[i] = it.next();
        }
        return sm;
    }

    public ForeignCollection<InputSubmethods> getSubmethods() {
        return submethods;
    }
    

    @Override
    public String toString() {
        return methods;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.methods != null ? this.methods.hashCode() : 0);
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InputMethods other = (InputMethods) obj;
        if ((this.methods == null) ? (other.methods != null) : !this.methods.equals(other.methods)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
