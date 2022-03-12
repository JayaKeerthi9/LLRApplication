import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Registerer
 */
@WebServlet("/Registerer")
public class Registerer extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        String id = request.getParameter("UserId");
	        String n = request.getParameter("Name");	     
	        String e = request.getParameter("Mail");
	        String p = request.getParameter("Password");      
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection       				("jdbc:mysql://localhost:3306/MAINPROJECT", "root", "root");	 
	            PreparedStatement ps = ((Connection) con).prepareStatement
                       ("insert into USER values(?,?,?,?)");
	            ps.setString(1, id);
	            ps.setString(2, n);
	            ps.setString(3, e);
	            ps.setString(4, p);           
	            int i = ps.executeUpdate();
	            if (i > 0){
	            	RequestDispatcher req = request.getRequestDispatcher("Id.jsp");
	    			req.include(request, response);
	            }            	 
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
	         out.close();
	    }
	 }
