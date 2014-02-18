package filters;

/**
 * SystemAccessFilter — фильтр, который будет контролировать, вошел ли пользователь в систему.
 * Проверяется только первый вход с помощью анализа атрибута isLogged;
 *
 *
 * Класс SystemAccessFilter реализует интерфейс Filter.
 Обратите внимание на методы, которые имеет класс SystemAccessFilter:
 ·         init(FilterConfig config) — инициализация фильтра;
 ·         destroy() — уничтожение фильтра;
 ·         setFilterConfig(FilterConfig fc) — setter метод;
 ·         getFilterConfig() — getter метод;
 ·         doFilter(ServletRequest request,  ServletResponse response, FilterChain chain) — метод, определяющий функциональность фильтра.


 Метод doFilter запрашивает значение переменной isLogged текущего сеанса  (getSession().getAttribute(«isLogged»)),
 которое  равно   true, если пользователь зарегистрировался и вошел в систему, и не установлено в противном случае.
 Во втором случае фильтр перенаправляет запрос на страницу входа пользователя в систему login.html.
 *
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


public class SystemAccessFilter implements Filter {
    private FilterConfig filterConfig;
    public void setFilterConfig(FilterConfig fc) {
        filterConfig = fc;
    }
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (filterConfig == null){
            return;
        }
        ServletContext ctx = filterConfig.getServletContext();
        String logged = (String)((HttpServletRequest)request).getSession().getAttribute("isLogged");
        if (!"true".equals(logged)){
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/successLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
    public void init(FilterConfig config)  throws ServletException {
        this.filterConfig = config;
    }
    public void destroy() { }
}