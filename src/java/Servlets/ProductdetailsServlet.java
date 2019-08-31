 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.AdminRegisterDao;
import Dao.ProductDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sun.misc.IOUtils;

/**
 *
 * @author Chamindu
 */
//@WebServlet("/ProductdetailsServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class ProductdetailsServlet extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name= request.getParameter("name");
        float price=Float.parseFloat(request.getParameter("price")); 
        String details= request.getParameter("details");
        InputStream inputStream = null;
        Part filePart = request.getPart("image");
         if (filePart != null) {
           inputStream = filePart.getInputStream();
        }
        
        PrintWriter out=response.getWriter();
        ProductDao pd = new ProductDao();
        
        try {
            pd.input(name,price,details,inputStream);
            HttpSession session =request.getSession();
            session.setAttribute("name", name);
            byte[] ar = pd.getdetail(name);
            String im = Base64.getEncoder().encodeToString(ar);
            session.setAttribute("imgBase",im);
           response.sendRedirect("product-detail.jsp");
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
