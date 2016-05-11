/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 1
 */
public class InputSubmethodsService {
    
    private final String url = "jdbc:sqlite:DataBase.sqlite";
    private ConnectionSource source;
    private Dao<InputSubmethods, String> dao;

    public InputSubmethodsService() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, InputSubmethods.class);
    }

    public List<InputSubmethods> getAll() throws SQLException {
        return dao.queryForAll();
    }
    
}
