package com.tco.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    private static String USER = "cs314-db";
    private static String PASSWORD = "eiK5liet1uej";
    private String URL;//sub/separate class?

    public Database() {
        String useTunnel = System.getenv("CS314_USE_DATABASE_TUNNEL");
        if(useTunnel != null && useTunnel.equals("true")) {
            URL = "jdbc:mariadb://127.0.0.1:56247/cs314";
        } else {
            URL = "jdbc:mariadb://faure.cs.colostate.edu/cs314";
        }
    }
}
