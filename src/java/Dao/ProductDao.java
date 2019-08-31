/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Chamindu
 */
public class ProductDao {
        String url = "jdbc:mysql://localhost:3306/a project";
        String username = "root";
        String password = "";
    
    public void input(String name, float price, String details, InputStream image) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            Statement st = conn.createStatement();
            String quary="INSERT INTO details(name,price,details,image) VALUES ('" + name + "','" + price + "','" + details + "','" +  image + "')";
            st.executeUpdate(quary);
    }

    
   public byte[] getdetail(String name) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            Statement st = conn.createStatement();
            String quary="SELECT image FROM details where name='"+name+"'";
           ResultSet r= st.executeQuery(quary);
           byte[] my= r.getBytes("image");
           return my;
   
   }
    
    
}
