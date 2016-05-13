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
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author 1
 */
@DatabaseTable(tableName = "SetOfSensors")
public class SetOfSensors {
    @DatabaseField(columnName = "idOfSet", generatedId = true)
    int idOfSet;
    
    @DatabaseField(columnName = "nameOfSet")
    String nameOfSet;
    
    @ForeignCollectionField(foreignFieldName="idOfSet")
    private ForeignCollection<ItemsOfSetOfSensors> sensorsOfSet;

    public SetOfSensors() {
    }

    public SetOfSensors(String nameOfSet) {
        this.nameOfSet = nameOfSet;
    }

    public String getNameOfSet() {
        return nameOfSet;
    }
    
    public int getidOfSet() {
        return idOfSet;
    }

    public ForeignCollection<ItemsOfSetOfSensors> getSensorsOfSet() {
        return sensorsOfSet;
    }


    @Override
    public String toString() {
        return nameOfSet;
    }
    
    public Sensors[] getSetAsArray() throws SQLException{
//        String itemsIds[] = itemsOfSet.split(" ");
//        int itemsCount = itemsIds.length;
//        Sensors items[] = new Sensors[itemsCount];
//        DataService<Sensors> ds = new DataService(Sensors.class);
//        for(int i = 0; i < itemsCount; i++)
//            items[i] = ds.getElementById(itemsIds[i]);

        Sensors items[];
        items = (Sensors[])Array.newInstance(Sensors.class, sensorsOfSet.size());
        DataService<Sensors> ds = new DataService(Sensors.class);
        int i = 0;        
        for (Iterator<ItemsOfSetOfSensors> it = sensorsOfSet.iterator(); it.hasNext(); i++) {
            items[i] = ds.getElementById(it.next().getSensorId());
        }

        return items;
    }
}
