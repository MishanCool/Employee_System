
package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MISHAN
 */
public class DbOperation {
    
    String url = "jdbc:mysql://localhost:3306/java_employee";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    
    
    
    void addEmployee(EmployeeDetails ed) throws SQLException{
        
        try {
            con = (Connection)DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.print(e);
        }
        
        try {
            String query = "INSERT INTO employeedetails VALUES(?,?,?,?,?,?,?,?)";

            pst = (PreparedStatement)con.prepareStatement(query);

            pst.setInt(1, ed.getRegID());
            pst.setString(2, ed.getFirstName());
            pst.setString(3, ed.getLastName());
            pst.setInt(4, ed.getAge());
            pst.setString(5, ed.getCountry());
            pst.setString(6, ed.getEmail());
            pst.setString(7, ed.getUserName());
            pst.setString(8, ed.getPassword());

            pst.executeUpdate();
        
        } catch (Exception e) {
            System.out.print(e);
        }
        
    }
    
}
