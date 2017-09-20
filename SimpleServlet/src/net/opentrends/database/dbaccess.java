package net.opentrends.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbaccess
 */
@WebServlet("/dbaccesspath")
public class dbaccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			out.println("<h1>Hai</h1>");
			String DBurl="jdbc:mysql://localhost/demo1";
			String username="dbuser";
			String password="db1234";
			Connection con=DriverManager.getConnection(DBurl,username,password);
			System.out.println("Connection established");
			PreparedStatement stmt=con.prepareStatement("select * from login where uname=? and password=?");
			String un=request.getParameter("uname");
			String pw=request.getParameter("pass");
			stmt.setString(1,un);
			stmt.setString(2,pw);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				out.println("<p><h2>Welcome "+rs.getString(1)+"</h2></p>");
			}else {
				out.println("<p>invalid user id or password</p>");
			}
		}catch(SQLException e) {
				out.println("<p>Database Connection Error-</p>"+e.getMessage());
		}
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				out.println("<p>class not found-"+e.getMessage()+"</p>");
		}
		catch(Exception ex) {
			out.println(ex.getMessage());
		}
		
	}

}
