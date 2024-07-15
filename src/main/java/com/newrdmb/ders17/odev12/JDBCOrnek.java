package com.newrdmb.ders17.odev12;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCOrnek {
    private static JDBCOrnek instance = null;
    private  Connection connection;
   // private final String url = "jdbc:postgresql://127.0.0.1:5432/personel";

    private final String url = "jdbc:mysql://127.0.0.1:3306/personel";
    //private final String username = "postgres";
    private final String username = "root";

    //private final String password = "1qaz2wsx@";
     private final String password= "123456qazW";
    private JDBCOrnek(){
        try {
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to Mysql!");


            }
        } catch (SQLException e) {
            System.out.println("Connection failed: ");
        }

    }
    public static JDBCOrnek getInstance(){

            if (instance == null) {
                instance = new JDBCOrnek();
            }
            return instance;


    }
    public  Connection getConnection() {
        return connection;
    }
}
