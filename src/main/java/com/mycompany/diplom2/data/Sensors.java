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
@DatabaseTable(tableName = "Sensors")
public class Sensors {
    @DatabaseField(columnName = "sensorId", generatedId = true)
    int sensorId;
    
    @DatabaseField(columnName = "sensorFullName")
    String sensorFullName;
    
    @DatabaseField(columnName = "sensorShortName")
    String sensorShortName;

    public Sensors() {
    }

    public Sensors(String sensorFullName, String sensorShortName) {
        this.sensorFullName = sensorFullName;
        this.sensorShortName = sensorShortName;
    }

    public int getSensorId() {
        return sensorId;
    }

    public String getSensorFullName() {
        return sensorFullName;
    }

    public String getSensorShortName() {
        return sensorShortName;
    }

    @Override
    public String toString() {
        return  sensorFullName + "( " + sensorShortName + " )";
    }
}
