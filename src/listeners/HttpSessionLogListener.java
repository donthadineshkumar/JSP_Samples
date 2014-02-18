package listeners;

/**
 * Слушатель событий реагирует на начало сеанса HTTP и на его завершение:
     метод sessionCreated (HttpSessionEvent   se)  — выводит в файл  .log сообщение "Session with id = <Идентификатор_сеанса> is started.";
     метод sessionDestroyed (HttpSessionEvent   se) —  выводит  в файл   .log сообщение "Session with id = <Идентификатор_сеанса> is finished.".
 */

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;


public class HttpSessionLogListener implements HttpSessionListener {
    public HttpSessionLogListener(){
    }
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext ctx = session.getServletContext();
        ctx.log("Session with id = " + session.getId() + " is started");
    }
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext ctx = session.getServletContext();
        ctx.log("Session with id = " + session.getId() + " is finished");
    }
}