package com.newrdmb.ders17JDBI.odev12;

import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBIOrnek {
    private static JDBIOrnek instance = null;
    private Jdbi jdbi;
    private final String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7719424";
    private final String username = "sql7719424";
    private final String password = "D9PnkZmuP3";

    private JDBIOrnek() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connected to MySQL!");
                jdbi = Jdbi.create(connection);
            }
        } catch (SQLException e) {
            System.out.println(STR."Connection failed: \{e.getMessage()}");
        }
    }

    public static JDBIOrnek getInstance() {
        if (instance == null) {
            instance = new JDBIOrnek();
        }
        return instance;
    }

    public Jdbi getJdbi() {
        return jdbi;
    }
}

