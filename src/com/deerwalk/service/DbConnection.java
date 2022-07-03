package com.deerwalk.service;

import com.deerwalk.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dell on 10/30/2017.
 */
public class DbConnection {
    public Connection getDbconnection(){
        String DBURL="jdbc:mysql://localhost:3306/quiz";
        String USERNAME="root";
        String PASSWORD="";
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            //System.out.println("Database Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
