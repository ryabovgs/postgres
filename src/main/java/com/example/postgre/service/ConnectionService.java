package com.example.postgre.service;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class ConnectionService {

    private final String url = "jdbc:postgresql://localhost:15432/compose-postgres";
    private final String user = "compose-postgres";
    private final String password = "compose-postgres";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            Statement statement = connection.createStatement();
            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = statement.executeQuery("select * from customer");
//            System.out.println(result+" records affected");
            rs.absolute(3);
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            connection.close();
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
