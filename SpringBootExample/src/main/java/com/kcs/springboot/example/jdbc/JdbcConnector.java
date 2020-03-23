package com.kcs.springboot.example.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class JdbcConnector {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/kcs";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";

    public Connection createConnection(){
        try{
       return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
    catch (SQLException e){
        System.out.println(e.getMessage());
        }
        return null;
    }

    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection connection = createConnection();
        if(connection == null){
            throw new SQLException("Connection is null");
        }
        return connection.prepareStatement(query);
    }
}
