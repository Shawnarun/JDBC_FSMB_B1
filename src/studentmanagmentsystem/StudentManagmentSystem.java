package studentmanagmentsystem;
import java.sql.*;

public class StudentManagmentSystem {
    public static void main(String[] args) throws Exception{
     callGetNameById();
    }
    
    public static Connection dbConnction() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/devAcademy";
        String user="root";
        String password="123456";
        Connection con=DriverManager.getConnection(url, user, password);
        return con;
    }
    
    public static void getAllStudent() throws Exception{
       
        String sql="SELECT * from student";
        try (Connection con = dbConnction()) {
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            String name="";
            while(rs.next())
            {
                name=rs.getString(2);
                System.out.println(name);
            }
        }
        
    }
    
    public static void insertStudent() throws Exception {
    

        String name= "Hasika";
        int age =21;
        String department="Engineering";
        String district="Batticaloa";
        String nic="2000655585V";
        String gender="Male";
        int performance=95;
        
        String sql="INSERT INTO student (name,age,department,district,nic,gender,performance)"
                + " VALUES (?,?,?,?,?,?,?)";
        try (Connection con = dbConnction()) {
            
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
    
    public static void deleteStudent() throws Exception{
            Connection con = dbConnction();
            int id=6;
            String sql="DELETE from student WHERE student_id= ? ";
            
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, id);
            int row = st.executeUpdate();
            System.out.println(row); 
    }
    
    public static void callGetAllStudent() throws Exception{
        Connection con = dbConnction();
        //Statement
        //PreparedStatement
        //CallableStatement
        CallableStatement cs =con.prepareCall("{call GetAll()}");
        ResultSet rs=cs.executeQuery();
        
        String name="";
            while(rs.next())
            {
                name=rs.getString(2);
                System.out.println(name);
            }
          
            
          
    }
    
    public static void callGetById() throws Exception{
          Connection con = dbConnction();
          int id=4;
           CallableStatement cs =con.prepareCall("{call GetByID(?)}");
           cs.setInt(1, id);
           ResultSet rs=cs.executeQuery();
           rs.next();
           System.out.println(rs.getString(2));
    }
    
      public static void callGetNameById() throws Exception{
          Connection con = dbConnction();
          int id=4;
           CallableStatement cs =con.prepareCall("{call GetNameByID(?,?)}");
           cs.setInt(1, id);
           cs.registerOutParameter(2,Types.VARCHAR);
           cs.executeUpdate();
         
           System.out.println(cs.getString(2));
    }
}
