package net.opentrends.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Displaypath")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://localhost/loginapp";
	private String un="dbuser";
	private String pw="db1234";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		String uname=(String)sess.getAttribute("uname");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h2>Hi Welcome "+uname+"</h2><br><br><b>Your Registration Details</b>");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, un, pw);
		System.out.println("Connection established");
		PreparedStatement stmt1=con.prepareStatement("select * from personalinfo where username=?");
		PreparedStatement stmt2=con.prepareStatement("select hobbies from hobbies where username=?");
		stmt1.setString(1, uname);
		stmt2.setString(1, uname);
		ResultSet rs1=stmt1.executeQuery();
		ResultSet rs2=stmt2.executeQuery();
		while(rs1.next()) {
		out.println("<br><br>Name: "+rs1.getString("name")+"<br><br>Gender: "+rs1.getString("gender")+"<br><br>Address:");
		String[] ad=rs1.getString("address").split(" ");
		for(String a:ad) {
			out.println("<br>"+a);
		}
		out.println("<br><br>Date of Birth: "+rs1.getString("birthdate"));
		}
		out.println("<br><br><br><br><b>Your Hobbies are: </b>");
		while(rs2.next()) {
			String[] hb=rs2.getString("hobbies").split(" ");
			for(String a:hb) {
				out.println("<br>"+a);
		}
		}
		out.println("<br><br><a href=\"Login.html\" ><button>Back</button></a>");
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
