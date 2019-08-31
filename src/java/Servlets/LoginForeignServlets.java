/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dinuk
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginForeignServlets extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("luname");
        String pword = request.getParameter("lpword");
        
        LoginDao log = new LoginDao();
       
        try {
            if (log.check(uname, pword))
            {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                response.sendRedirect("user.jsp");
            }
            else{
                HttpSession session2 = request.getSession();
                session2.setAttribute("errorMessage", "Invalid Username OR Password");
                response.sendRedirect("loginforeign.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginServlets.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }

}
