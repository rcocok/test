package com.keke.util;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTools {
    static {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //开启桥梁
 public  static Connection getConn(){
     Connection connection =null;
     try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa",
                 "root", "root");
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return connection;
 }
public  static  void closeConn(Connection connection){
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("链接关闭失败");
            }
        }
}

    public static void main(String[] args) {
        DBTools tools = new DBTools();
        Connection conn = tools.getConn();
        System.out.println("conn = " + conn);
        DBTools.closeConn(conn);


    }
}
