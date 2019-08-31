/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Chamindu
 */
public class ContactDao {
        String url = "jdbc:mysql://localhost:3306/a project";
        String username = "root";
        String password = "";
    
    public void input(String uname, String phone, String email, String massage) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            Statement st = conn.createStatement();
            String quary="INSERT INTO contact(username,phone,email,massage) VALUES ('" + uname + "','" + phone + "','" + email + "','" +  massage+ "')";
            st.executeUpdate(quary);
    }

    

    

    

    
    
}
