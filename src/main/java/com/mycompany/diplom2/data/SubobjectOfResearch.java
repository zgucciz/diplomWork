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
@DatabaseTable(tableName = "SubobjectOfResearch")
public class SubobjectOfResearch {
    
    public static SubobjectOfResearch NONE_SELECTED = new SubobjectOfResearch(null,"<Выбрать>",null);
    @DatabaseField(columnName = "Key", foreign = true)
    ResearchObject object;
    
    @DatabaseField(columnName = "Subobjects")
    String subobject;
    
    @DatabaseField(columnName = "Examples")
    String examples;
    
    public SubobjectOfResearch() {
        this.subobject = "";
        this.examples = "";
    }

    public SubobjectOfResearch(ResearchObject object, String subobject, String examples) {
        this.object = object;
        this.subobject = subobject;
        this.examples = examples;
    }

    @Override
    public String toString() {
        return subobject;
    }

    public void setSubobject(String subobject) {
        this.subobject = subobject;
    }

    public void setExamples(String examples) {
        this.examples = examples;
    }

    public String getSubobject() {
        return subobject;
    }

    public String getExamples() {
        return examples;
    }
    
}
