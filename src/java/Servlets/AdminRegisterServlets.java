 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.AdminRegisterDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chamindu
 */
public class AdminRegisterServlets extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname= request.getParameter("rfname");
        String uname= request.getParameter("runame");
         String pword= request.getParameter("rpword");
        String email= request.getParameter("remail");
        String phone= request.getParameter("rphone");
        
        PrintWriter out=response.getWriter();
        AdminRegisterDao rb = new AdminRegisterDao();
        
        try {
            rb.input(fname,uname,pword,email,phone);
           response.sendRedirect("adminregister.jsp");
        } 
        catch (Exception e) {
           out.println(e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
