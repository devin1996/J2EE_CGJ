
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Chamindu
 */
public class RegisterForeignDao {
        String url = "jdbc:mysql://localhost:3306/a project";
        String username = "root";
        String password = "";
    
    public void input(String fname, String uname, String pword, String email, String phone, String country) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            Statement st = conn.createStatement();
            String quary="INSERT INTO fregister (fullname,username,password,email,phone,country) VALUES ('" + fname + "','" + uname + "','" +pword + "','" +  email+ "','" + phone+ "','" + country+ "')";
            st.executeUpdate(quary);
    }

    

    

    
    
}
