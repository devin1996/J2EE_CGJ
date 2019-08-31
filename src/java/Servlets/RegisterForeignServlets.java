/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.RegisterDao;
import Dao.RegisterForeignDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chamindu
 */
public class RegisterForeignServlets extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname= request.getParameter("rfname");
        String uname= request.getParameter("runame");
         String pword= request.getParameter("rpword");
        String email= request.getParameter("remail");
        String phone= request.getParameter("rphone");
        String country= request.getParameter("rcountry");
        
        PrintWriter out=response.getWriter();
        RegisterForeignDao rb = new RegisterForeignDao();
        
        try {
            rb.input(fname,uname,pword,email,phone,country);
           response.sendRedirect("foreignlogin.jsp");
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
