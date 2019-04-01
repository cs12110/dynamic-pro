package com.pkgs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-31 11:00
 * <p>
 * @since 1.0.0
 */
public class JdbcUtil {

    static {
        loadDriver();
    }

    public static Connection getConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
