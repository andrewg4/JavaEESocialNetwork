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
@WebServlet(name = "SignInServlet", urlPatterns = {"signin"})
public class SignInServlet extends HttpServlet {

    DbSimulator dbSimulator;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // initialize authorisation data
       dbSimulator = new DbSimulator("Test@Email", "TestPassword");

        // get authorisation data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // check if user data is correct
        if (dbSimulator.getEmail().equals(email) || dbSimulator.getPassword().equals(password)){
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
        // redirect to login page
        else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req,resp);
    }
}
