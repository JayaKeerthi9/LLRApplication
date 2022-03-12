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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        String n=request.getParameter("userid");  
        String p=request.getParameter("pass");        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);
        if(LoginDao.validate(n, p)){  
            RequestDispatcher rd=request.getRequestDispatcher("home1.html");  
            rd.forward(request,response);  
        }  
        else{                
            RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
            rd.include(request,response);  
        }  
        out.close();  
    }  
}
