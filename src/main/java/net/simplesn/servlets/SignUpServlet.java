package net.simplesn.servlets;

import net.simplesn.db.DbSimulator;

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

    DbSimulator dbSimulator = new DbSimulator();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get registration data
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // create new user and add him to the list of new users
        DbSimulator potencialNewUser = new DbSimulator(name, password, email);

        // if a user with the registration data doesn't exist, redirect him to login page
        if (dbSimulator.exist(potencialNewUser)){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            dbSimulator.getNewUsers().add(potencialNewUser);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
