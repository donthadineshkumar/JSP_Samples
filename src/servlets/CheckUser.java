package servlets;

/* Класс CheckUser, расширяющий класс Dispatcher, проверяет наличие текущего пользователя
в списке зарегистрированных пользователей и перенаправляет запрос:
·         на страницу successLogin.jsp, если пользователь в списке найден;
·         на страницу registration.html в противном случае.
*/

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CheckUser extends Dispatcher {
    public String getServletInfo(){
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = UserList.findUser(request.getParameter("user"));
        if (user == null){
            this.forward("/registration.html", request, response);
        } else {
            if
                    (!user.getPassword().equals(request.getParameter("password"))){
                this.forward("/registration.html", request, response);
            } else {
                request.getSession().setAttribute("isLogged","true");   //  устанавливает значение true переменной isLogged.
                this.forward("/successLogin.jsp", request, response);
            }
        }
    }

}