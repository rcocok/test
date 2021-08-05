package com.keke.servlet;

import com.keke.bean.User;
import com.keke.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/regServlet")
public class RegServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        System.out.println("name = " + name);
         UserDao ud = new UserDao();
         User u = ud.FindByName(name);
        if (u!=null){
            response.getWriter().write("1");
        }else{
            response.getWriter().write("2");
        }
    }


}
