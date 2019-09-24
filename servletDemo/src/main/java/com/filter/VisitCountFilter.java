package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;

/**
 * 通过自定义filter实现统计每个IP的访问情况，通过页面visitHistory.jsp进行展示
 */
@WebFilter(urlPatterns = "/*")
public class VisitCountFilter implements Filter {
    private static HashMap<String,Integer> visitHistory = new HashMap<String, Integer>();

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("**VisitCountFilter initing ... ...");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteAddr = servletRequest.getRemoteAddr();
        String remoteHost = servletRequest.getRemoteHost();
        int count = visitHistory.getOrDefault(remoteAddr, 0);
        visitHistory.put(remoteAddr, Integer.valueOf(count + 1));
        servletRequest.getServletContext().setAttribute("visithistory",visitHistory);
        System.out.println("visit: addr "+ remoteAddr + ", remoteHost " + remoteHost);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
