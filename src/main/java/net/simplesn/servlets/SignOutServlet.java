package net.simplesn.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Andrew on 02.07.2015.
 */
@WebServlet (name = "SignOutServlet", urlPatterns = "signout")
public class SignOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        String email = req.getParameter("email");

        // If you are not in a session - you are not logged in
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(email)){
                    // clear cookie
                    cookie.setMaxAge(0);
                    break;
                }
            }
        }

        //invalidate the session if exists
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        // redirect to login page
        resp.sendRedirect("index.jsp");
    }
}
