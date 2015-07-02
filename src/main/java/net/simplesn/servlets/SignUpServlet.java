package net.simplesn.servlets;

import net.simplesn.db.DbSimulator;
import net.simplesn.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew on 30.06.2015.
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"signup"})
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get registration data
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // if a user with the registration data doesn't exist, redirect him to login page
        if (DbSimulator.getDB().isRegisteredUser(email, password)){
            request.getRequestDispatcher("failuresignup.jsp").forward(request, response);
        }
        // create new user and add him to the list of users
        else {
            DbSimulator.getDB().getNewUsers().add(new UserVo(name, password, email));
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("successregistration.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
