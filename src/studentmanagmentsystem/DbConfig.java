
package studentmanagmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
    private static DbConfig instance ;
    
    private DbConfig(){
    }
    
    public static synchronized DbConfig getInstance(){
        if(instance == null){
            instance = new DbConfig();
        }
        
        return instance;
        }
    
       public Connection dbConnction() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/devAcademy";
        String user="root";
        String password="123456";
        Connection con=DriverManager.getConnection(url, user, password);
        return con;
    }
    
}
