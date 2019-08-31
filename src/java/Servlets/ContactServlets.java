/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.ContactDao;
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
public class ContactServlets extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname= request.getParameter("cuname");       
        String phone= request.getParameter("cphone");
        String email= request.getParameter("cemail");
        String massage= request.getParameter("cmassage");
        
        PrintWriter out=response.getWriter();
        ContactDao cb = new ContactDao();
        
        try {
            cb.input(uname,phone,email,massage);
            response.sendRedirect("contact.jsp");
        } catch (Exception e) {
           out.println(e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
