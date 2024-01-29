package studentmanagmentsystem;
import java.sql.*;
/*
1.import 
2.load and register
3.Create connection
4.Create Statement
5.Excute Statement
6.Process Result
7.Close
*/
public class StudentManagmentSystem {
    public static void main(String[] args) throws Exception{
       Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/devAcademy";
        String user="root";
        String password="123456";
        
        String sql="SELECT * from student WHERE age=24";
       
       Connection con=DriverManager.getConnection(url, user, password);
       Statement st=con.createStatement();
           ResultSet rs= st.executeQuery(sql);
       
           rs.next();
           String name=rs.getString("name");
        
        System.out.println(name);
    }
    
}
