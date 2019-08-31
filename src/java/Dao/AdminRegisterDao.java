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
public class AdminRegisterDao {
        String url = "jdbc:mysql://localhost:3306/a project";
        String username = "root";
        String password = "";
    
    public void input(String fname, String uname, String pword, String email, String phone) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            Statement st = conn.createStatement();
            String quary="INSERT INTO admin(fullname,username,password,email,phone) VALUES ('" + fname + "','" + uname + "','" +pword + "','" +  email+ "','" + phone+ "')";
            st.executeUpdate(quary);
    }

    

    
    
}
