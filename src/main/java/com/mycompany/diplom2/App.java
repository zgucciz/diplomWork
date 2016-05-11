package com.mycompany.diplom2;

import com.mycompany.diplom2.data.DataService;
import com.mycompany.diplom2.data.GUI.Gui;
import com.mycompany.diplom2.data.GUI.extraWindows.usersChoose;
import com.mycompany.diplom2.data.InputMethods;
import com.mycompany.diplom2.data.InputMethodsService;
import com.mycompany.diplom2.data.ResearchObject;
import com.mycompany.diplom2.data.ResearchObjectService;
import com.mycompany.diplom2.data.Sensors;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws SQLException {
//        System.out.println("Hello World!");
//        // this uses h2 but you can change it to match your database
//        ResearchObjectService rs  = new ResearchObjectService();
//        List<ResearchObject> allRO = rs.getAll();
//        
//        DataService<ResearchObject> ds = new DataService(ResearchObject.class);
//        List<ResearchObject> allRO1 = ds.getAll();
//        
//        
//        Iterator iteratorRO = allRO.get(2).getSubobjects().iterator();
//        while(iteratorRO.hasNext())
//        System.out.println(iteratorRO.next() );
//        
//        InputMethodsService ms = new InputMethodsService();
//        List<InputMethods> allIM = ms.getAll();
//        
//        Iterator iteratorIM = allIM.get(2).getSubmethods().iterator();
//        while(iteratorIM.hasNext())
//        System.out.println(iteratorIM.next() );
        
  //      Gui.run(); //ВРЕМЕННО!!
        usersChoose.run();
    }
}
