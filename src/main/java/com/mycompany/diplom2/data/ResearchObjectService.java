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
public class ResearchObjectService {

    private final String url = "jdbc:sqlite:DataBase.sqlite";
    private ConnectionSource source;
    private Dao<ResearchObject, String> dao;

    public ResearchObjectService() throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, ResearchObject.class);
    }

    public List<ResearchObject> getAll() throws SQLException {
        return dao.queryForAll();
    }
}
