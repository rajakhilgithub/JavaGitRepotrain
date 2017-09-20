package net.opentrends.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Registerpath")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://localhost/loginapp";
	private String un="dbuser";
	private String pw="db1234";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("uname").trim();
		String password=request.getParameter("pass").trim();
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String address=request.getParameter("Address");
		String dob=request.getParameter("bday");
		String [] hb=request.getParameterValues("hobbies");
		String hobby="";
		for(String a:hb) {
			hobby=hobby+" "+a;
		}
//		System.out.println(hobby);
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, un, pw);
			System.out.println("Connection established");
			PreparedStatement stmt1=con.prepareStatement("insert into login values(?,?)");
			PreparedStatement stmt2=con.prepareStatement("insert into personalinfo values(?,?,?,?,?)");
			PreparedStatement stmt3=con.prepareStatement("insert into hobbies values(?,?)");
			stmt1.setString(1, username);
			stmt1.setString(2, password);
			stmt2.setString(1, username);
			stmt2.setString(2, name);
			stmt2.setString(3, gender);
			stmt2.setString(4, address);
			stmt2.setString(5, dob);
			stmt3.setString(1, username);
			stmt3.setString(2, hobby);
			int rs1=stmt1.executeUpdate();
			int rs2=stmt2.executeUpdate();
			int rs3=stmt3.executeUpdate();
			if(rs1==1&&rs2==1&&rs3==1) {
				out.println("<p style=\"color:#FF0000\">Registration Successfull</p>");
				HttpSession sess=request.getSession();
				sess.setAttribute("uname", username);
				RequestDispatcher rd=request.getRequestDispatcher("/Displaypath");
				rd.include(request, response);
			}else {
				out.println("<p style=\"color:#FF0000\">Registration failed</p>");
				RequestDispatcher rd=request.getRequestDispatcher("/Signup.html");
				rd.include(request, response);
			}
			
			
		}
		catch(SQLException e) {
			out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			out.println(e.getMessage());
		}
		catch(Exception e) {
			out.println(e.getMessage());
		}
	}

}
