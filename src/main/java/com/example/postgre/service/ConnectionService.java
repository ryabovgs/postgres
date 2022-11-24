package com.example.postgre.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionService {

    private final String url = "jdbc:postgresql://localhost/dvdrental";
    private final String user = "postgres";
    private final String password = "<add your password>";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
//        Statement stmt=con.createStatement();
//
////stmt.executeUpdate("insert into emp765 values(33,'Irfan',50000)");
////int result=stmt.executeUpdate("update emp765 set name='Vimal',salary=10000 where id=33");
//        int result=stmt.executeUpdate("delete from emp765 where id=33");
//        System.out.println(result+" records affected");
//        con.close();
    }
}
