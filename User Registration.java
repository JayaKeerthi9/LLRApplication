import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class Userreg
 */
@WebServlet("/Userreg")
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 1,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 15)
public class Userreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("name");
		String g=request.getParameter("Gender");
		String re=request.getParameter("Rela");		
		String r=request.getParameter("Relation");
		String p=request.getParameter("Permanent");
		String d=request.getParameter("Door");		
		String t=request.getParameter("Temporary");
		String dt=request.getParameter("District");
		String s=request.getParameter("Street");		
		String c=request.getParameter("City");
		String pin=request.getParameter("Pin");
		String ph=request.getParameter("Phone");		
		String aa=request.getParameter("Aadhaar");
		String em=request.getParameter("email");
		String rto=request.getParameter("RTO");		
		String ty=request.getParameter("TransactionType");
		//String doc=request.getParameter("Document");		
		InputStream inputStream = null;
		 Part filePart = request.getPart("Document");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();		
		String dat=request.getParameter("date");		
		//String app=request.getParameter("ApplicationNo");
		String dob=request.getParameter("dob");
		String pss=request.getParameter("password");
		Random ran=new Random();
		String id = Integer.toString(ran.nextInt(46754657) + 1000);		
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection 					("jdbc:mysql://localhost:3306/mainproject", "root", "root");	 
	            PreparedStatement ps = ((Connection) con).prepareStatement
		("insert into userreg values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            ps.setString(1, id);
	            ps.setString(2, n);
	            ps.setString(3, g);
	            ps.setString(4, re);	            
	            ps.setString(5, r);
	            ps.setString(6, p);
	            ps.setString(7, d);	            
	            ps.setString(8, t);
	            ps.setString(9, dt);
	            ps.setString(10, s);	            
	            ps.setString(11, c);
	            ps.setString(12, pin);
	            ps.setString(13, ph);         
	            ps.setString(14, aa);
	            ps.setString(15, em);
	            ps.setString(16, rto);          
	            ps.setString(17, ty);
	             if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                ps.setBlob(18, inputStream);
	            }
	            ps.setString(19, dat);           
	           // ps.setString(19, app);
	            ps.setString(20, dob);
	            ps.setString(21, pss);
	            ps.setString(22,null);
	            ps.setString(23,"0/0/0");       
	            int i = ps.executeUpdate();
	            if (i > 0){
	            	RequestDispatcher req = request.getRequestDispatcher("app.jsp");
	    			req.include(request, response);
	            }  
		}catch(Exception sql)
		{
			sql.printStackTrace();
		}
		}
}
}
