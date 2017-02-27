package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Auth implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter init called");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    	HttpServletResponse response = (HttpServletResponse) resp;
    	HttpServletRequest request = (HttpServletRequest) req;
    
		 HttpSession session = request.getSession(true);
		 if (session.getAttribute("UserId") == null) {
			 response.sendRedirect("/login.html");
		 }
    	
    	
    }
    
    public void destroy() {
        System.out.println("Filter destroy called");
    }
}
