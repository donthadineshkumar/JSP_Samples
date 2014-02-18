package filters;

/**
 LoggerFilter - фильтр, который используется для занесения в файл log записей обо всех поступивших запросах к системе.

 Во втором фильтре присутствует тот же набор методов, что и в первом. Метод doFilter()
 в данном случае просто записывает в файл log время запроса, какой ресурс был запрошен
 и с какого хоста этот ресурс был запрошен:
 ctx.log("" + new Date() + " - resourse: " + ((HttpServletRequest)request).getRequestURL() + " is requested by: " + request.getRemoteHost());
 */


import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;


public class LoggerFilter implements Filter {
    private FilterConfig filterConfig;
    public void setFilterConfig(FilterConfig fc) {
        filterConfig = fc;
    }
    public FilterConfig getFilterConfig () {
        return filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (filterConfig == null){
            return;
        }
        ServletContext ctx = filterConfig.getServletContext();
        ctx.log("" + new Date() + " - resourse: " + ((HttpServletRequest)request).getRequestURL() + " is requested by: " + request.getRemoteHost());
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config)  throws ServletException {
        this.filterConfig = config;
    }
    public void destroy() { }
}