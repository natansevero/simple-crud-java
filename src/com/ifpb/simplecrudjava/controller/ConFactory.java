

package com.ifpb.simplecrudjava.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author natan
 */
public class ConFactory {
    public static Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName("org.postresql.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
