package net.opentrends.shoppingcart.filter;

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

@WebFilter(filterName = "LoggedInCheckPath", urlPatterns = "/*")
public class LoggedInCheck implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String url = httpRequest.getRequestURI();
		if (url.endsWith("/addProduct") || url.endsWith("/buyerHome") || url.endsWith("/orderList")
				|| url.endsWith("/sellerHome")) {
			HttpSession session = httpRequest.getSession();
			if ((session == null) || (session.getAttribute("username").toString().isEmpty())) {
				PrintWriter out = response.getWriter();
				out.println("<p class=\"error\" align=\"center\">Login to continue</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/login");
				rd.include(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
