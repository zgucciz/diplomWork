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

@DatabaseTable(tableName = "ItemsOfSetOfSensors")
public class ItemsOfSetOfSensors {
    @DatabaseField(columnName = "idOfSet", foreign = true)
    private SetOfSensors idOfSet;
    
    @DatabaseField(columnName = "sensorId")
    private String sensorId;

    public ItemsOfSetOfSensors() {
    }

    public String getSensorId() {
        return sensorId;
    }

    
}
