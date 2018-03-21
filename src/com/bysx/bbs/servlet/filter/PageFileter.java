package com.bysx.bbs.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bysx.bbs.domain.UserBase;

/**
 * 页面定位过滤器
 */
@WebFilter("/PageFileter")
public class PageFileter implements Filter {

    /**
     * Default constructor. 
     */
    public PageFileter() {
        // TODO Auto-generated constructor stub
    }

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
		String uri = ((HttpServletRequest)request).getRequestURI();
		if(uri.contains("admin/index")) {
			UserBase userBase = (UserBase) ((HttpServletRequest)request).getSession().getAttribute("userBase");
			if(userBase == null) {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
