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
        
        String name= "Hasika";
        int age =21;
        String department="Engineering";
        String district="Batticaloa";
        String nic="2000655585V";
        String gender="Male";
        int performance=95;
        
        String sql="INSERT INTO student (name,age,department,district,nic,gender,performance)"
                + " VALUES (?,?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            
            PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, department);
                ps.setString(4, district);
                ps.setString(5, nic);
                ps.setString(6, gender);
                ps.setInt(7, performance);
           int row= ps.executeUpdate();
            System.out.println(row);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
