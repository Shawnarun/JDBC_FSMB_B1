package studentmanagmentsystem;
import java.sql.*;

public class StudentManagmentSystem {
    public static void main(String[] args) throws Exception{
      insertStudent();
    }
    
    
    public static void getAllStudent() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/devAcademy";
        String user="root";
        String password="123456";
        
        String sql="SELECT * from student";
       
           Connection con=DriverManager.getConnection(url, user, password);
           Statement st=con.createStatement();
           ResultSet rs= st.executeQuery(sql);
      
           String name="";
         while(rs.next())
         {
          name=rs.getString(2);
          System.out.println(name);
         }     
        con.close();
        
    }
    
    public static void insertStudent() throws Exception {
    
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/devAcademy";
        String user="root";
        String password="123456";
        
        String sql="INSERT INTO student (name,age,department,district,nic,gender,performance) VALUES ('Sarangan shagar',52,'Engineering','Batticaloa','97655585V','Male',90)";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            
            Statement st=con.createStatement();
            int row=st.executeUpdate(sql);
           
            System.out.println(row);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
