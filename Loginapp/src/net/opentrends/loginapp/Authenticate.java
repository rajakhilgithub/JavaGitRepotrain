package net.opentrends.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Authenticate
 */
@WebServlet("/Authenticatepath")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://localhost/loginapp";
	private String un="dbuser";
	private String pw="db1234";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, un, pw);
			System.out.println("Connection established");
			PreparedStatement stmt1=con.prepareStatement("select * from login where username=? and password=?");
			stmt1.setString(1, username);
			stmt1.setString(2, password);
			ResultSet rs=stmt1.executeQuery();
			if(rs.next()) {
				HttpSession sess=request.getSession();
				sess.setAttribute("uname", username);
				response.sendRedirect("Displaypath");
			}else {
				out.println("<p style=\"color:#FF0000\">Invalid Username or Password</p>");
				RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
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
