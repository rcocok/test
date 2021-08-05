package com.keke.dao;

import com.keke.bean.User;
import com.keke.util.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User FindByName(String name) {
        Connection conn = DBTools.getConn();
        User u =null;
        String sql="select * from user where name= ? ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 u = new User();
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String pwd = rs.getString("pwd");
                u.setId(id);
                u.setName(name1);
                u.setPwd(pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("检查sql语句是否正确");
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("链接关闭失败");

        }
        return  u;
    }
}
