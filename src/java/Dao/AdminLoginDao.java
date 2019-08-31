
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminLoginDao {
    String url = "jdbc:mysql://localhost:3306/a project";
    String username = "root";
    String password = "";
    String query = "select username,password from admin where username= ? and password= ? ";

    public boolean check(String uname, String pword) throws Exception
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username, password);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,uname);
            pst.setString(2,pword);
            ResultSet rs = pst.executeQuery();
        
            if(rs.next())
                return true;
            
            
    
        return false;
    }
}
