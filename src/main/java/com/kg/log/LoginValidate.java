import java.io.IOException;  
import java.io.PrintWriter;     
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
      
      @WebServlet("/LoginValidate")
    public class LoginValidate extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("user");  
        String p=request.getParameter("pwd");  
     //   String u=request.getParameter("user"); 
        //if(u=="Admin") {    
        if(Login.validateAdmin(n,p)){  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.forward(request,response);  
        }  
          if(Login.validateUser(n,p)){  
            RequestDispatcher rd=request.getRequestDispatcher("");  
            rd.forward(request,response);  
        }  

        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
            rd.include(request,response);  
        }  
      //  }  
        out.close();  
        }  
    }  