package net.opentrends.carrental.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.Filter.Chain;

import net.opentrends.carrental.model.Login;
@WebFilter(filterName="LoggedInCheckPath",urlPatterns= "/*")
public class LoggedInCheck implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter");
		HttpServletRequest req=(HttpServletRequest)request;
		String url=req.getRequestURI();
		System.out.println("url="+url);
		if(url.endsWith("/home")||url.endsWith("/search")||url.endsWith("/newbrand")||url.endsWith("/newmodel")||url.endsWith("/newcustomer")) {
			System.out.println("Filter");
			String user=req.getSession().getAttribute("user").toString();
			System.out.println("user=>"+user);
			if(user.isEmpty()) {
				System.out.println("login again");
				PrintWriter out=response.getWriter();
				out.println("<p style=\"color:#FF0000\" align=\"center\">Login to continue</p>");
				RequestDispatcher rd=request.getRequestDispatcher("/login");
				rd.include(request, response);	
			}
			else {
		chain.doFilter(request, response);
			}
		}
		else {
			chain.doFilter(request, response);

		}
		/*HttpServletRequest req=(HttpServletRequest)request;
		String user=req.getSession().getAttribute("user").toString();
		if(user.isEmpty()) {
			System.out.println("login again");
			PrintWriter out=response.getWriter();
			out.println("<p style=\"color:#FF0000\">Login to continue</p>");
			RequestDispatcher rd=request.getRequestDispatcher("/login");
			rd.include(request, response);	
			
			
		}
		else {
			chain.doFilter(request, response);

		}*/
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
