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
@DatabaseTable(tableName = "ResearchObject")
public class ResearchObject {
    public static ResearchObject NONE_SELECTED = new ResearchObject("<Выбрать>", Integer.MAX_VALUE);

    @DatabaseField(columnName = "objects")
    String object;
    
    @DatabaseField(columnName = "id", generatedId = true)
    int id;
    
    @ForeignCollectionField
    private ForeignCollection<SubobjectOfResearch> subobjects;

    public ResearchObject() {
        this.object = "";
    }

    public ResearchObject(String object) {
        this.object = object;
    }

    public ResearchObject(String object, int id) {
        this.object = object;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public ForeignCollection<SubobjectOfResearch> getSubobjects() {
        return subobjects;
    }
    
    public SubobjectOfResearch[] getSubobjectsAsArray() {
        SubobjectOfResearch so[];
        so = (SubobjectOfResearch[])Array.newInstance(SubobjectOfResearch.class, subobjects.size());
        int i = 0;        
        for (Iterator<SubobjectOfResearch> it = subobjects.iterator(); it.hasNext(); i++) {
            so[i] = it.next();
        }
        return so;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return object;
    }

    
}
