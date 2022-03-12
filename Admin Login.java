import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();          
        String n=request.getParameter("name");  
        String p=request.getParameter("psw");       
         if(admincheck.valid(n, p)){  
            RequestDispatcher rd=request.getRequestDispatcher("user.jsp");  
            rd.forward(request,response);  
        }  
        else{                
            RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");  
            rd.include(request,response);  
        }  
        out.close();  
    }  
}
