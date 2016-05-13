/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diplom2.data;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 1
 */
public class DataService<T> {

    private final String url = "jdbc:sqlite:DataBase.sqlite";
    private ConnectionSource source;
    private Dao<T, String> dao;
    private Class type;

    public DataService(Class t) throws SQLException {
        source = new JdbcConnectionSource(url);
        dao = DaoManager.createDao(source, t);
        type = t;
    }

    public List<T> getAll() throws SQLException {
        return dao.queryForAll();
    }

    public T[] getAllAsArray() throws SQLException {
        List<T> data = dao.queryForAll();
        T m[];
        m = (T[])Array.newInstance(type, data.size());
        int i = 0;        
        for (Iterator<T> it = data.iterator(); it.hasNext(); i++) {
            m[i] = it.next();
        }
        dao.closeLastIterator(); 
        return m;
    }
    
    public T getElementById(String id) throws SQLException {
        return dao.queryForId(id);
    }
    
    public int create(T t) throws SQLException{
        return dao.create(t);
    }
    
    public int delete(T t) throws SQLException{
        return dao.delete(t); 
    }
    
    public void deleteByValue(String columnName, Object value) throws SQLException{
        com.j256.ormlite.stmt.DeleteBuilder db = dao.deleteBuilder();
        db.where().eq(columnName, value);
        db.delete();
    }
}
