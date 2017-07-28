import java.sql.*;  
  
public class Login {  
 public static Connection getConnection(){  
            Connection con=null;  
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/logo", "root", "");  
            }catch(Exception e){System.out.println(e);}  
            return con;  
        }  
 
public static boolean validateAdmin(String user,String pwd){  
boolean status=false;  
try{  
     
  Connection con=Login.getConnection();     
PreparedStatement ps=con.prepareStatement(  
"select * from login where user=? and pwd=? ");  
ps.setString(1,user);  
ps.setString(2,pwd);  
//ps.setString(3,user);
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
public static boolean validateUser(String username,String userpass){  
boolean status=false;  
try{  
     
  Connection con=Login.getConnection();     
PreparedStatement ps=con.prepareStatement(  
"select * from admin where user=? and pwd=? ");  
ps.setString(1,username);  
ps.setString(2,userpass);  
//ps.setString(3,user);
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}