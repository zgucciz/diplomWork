package com.mycompany.diplom2;

import com.mycompany.diplom2.data.DataService;
import com.mycompany.diplom2.data.GUI.DiagramFrame;
import com.mycompany.diplom2.data.GUI.extraWindows.usersChoose;
import com.mycompany.diplom2.data.SetOfSensors;
import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws SQLException {

        
//        Gui.run(); //ВРЕМЕННО!!
        usersChoose.run();
//        DataService<SetOfSensors> ds;
//            ds = new DataService(SetOfSensors.class);
//            SetOfSensors allSets[] = ds.getAllAsArray();
//        DiagramFrame.run(allSets[2], new Double[]{7.,4.,12.,7.,10.,9.,5.});
        
    }
}
