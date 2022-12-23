package com.hnnny.toy_servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Commons {
    // statement 만들기
    public Statement getStatement(){
        String url = "jdbc:mysql://localhost:3306/toys_JavaWithDB";
        String user = "root";
        String password = "*khacademy!";

        Statement statement = null;

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement;
    }
}
