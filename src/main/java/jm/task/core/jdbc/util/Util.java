package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

   private static final String dbURL = "jdbc:mysql://localhost:3306/mydb1";
   private static final String dbUserName = "root";
   private static final String dbPassword = "Maxim_180299";


    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Не подключился к БД");
            e.printStackTrace();
        }
        return connection;
    }
}
