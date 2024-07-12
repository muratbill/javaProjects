package com.newrdmb.ders17.odev12;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        JDBCOrnek instance = JDBCOrnek.getInstance();
        Connection conn = instance.getConnection();
        if (conn == null) {
            System.err.println("Failed to establish connection. Exiting.");
            return;
        }
        DBOperations dboper = new DBOperations(conn);
        try {
     //  dboper.insertData("John Wayne", "Engineer", 43, "Engineering", 1234);
       // dboper.insertData( "Emma Watson", "Accountant", 43, "Finance", 1235);
      //  dboper.insertData("Mehmet Can", "Project Manager", 45, "R&D", 1236);
       //dboper.insertData("Ken West", "Security", 35, "Security", 1237);
                  dboper.updateData("Emily Wests","Nurse",null,"Medic",1237);
            //      dboper.deleteData(conn,1237);
            dboper.fetchData();
     //       dboper.deleteData(1237);
        }finally {
            dboper.closeConnection();
        }

    }


}