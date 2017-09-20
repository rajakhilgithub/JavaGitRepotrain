package net.opentrends.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Unameavail
 */
@WebFilter(filterName="/Unameavailpath",urlPatterns="/Registerpath")
public class Unameavail implements Filter {

	private String url="jdbc:mysql://localhost/loginapp";
	private String un="dbuser";
	private String pw="db1234";
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		String uname=request.getParameter("uname");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, un, pw);
			System.out.println("Connection established");
			PreparedStatement stmt1=con.prepareStatement("select * from login where username=?");
			stmt1.setString(1, uname);
			ResultSet rs=stmt1.executeQuery();
			
			if(rs.next()) {
				out.println("<p style=\"color:#FF0000\">Username unavailable</p>");
				RequestDispatcher rd=request.getRequestDispatcher("/Signup.html");
				rd.include(request, response);
			}
			else {
		chain.doFilter(request, response);
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
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
