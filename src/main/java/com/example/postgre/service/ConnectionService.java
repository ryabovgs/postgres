package com.example.postgre.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class ConnectionService {

    private final String url = "jdbc:postgresql://localhost:15432/compose-postgres";
    private final String user = "compose-postgres";
    private final String password = "compose-postgres";

    @SneakyThrows
    public Connection connect() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            System.out.println("Connected to the PostgreSQL server successfully.");
//            Statement statement = connection.createStatement();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            statement.addBatch("select * from customer");

//            PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?)");
//            stmt.setInt(1,101);//1 specifies the first parameter in the query
//            stmt.setString(2,"Ratan");

            var results = statement.executeBatch();
//            ResultSet rs = statement.executeQuery("select * from customer");
////            System.out.println(result+" records affected");
//            rs.absolute(3);
//            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
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
