package net.simplesn.servlets;

import net.simplesn.bean.UserBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrew on 07.07.2015.
 */
@WebServlet(name = "AddToFriendsServlet", urlPatterns = "addtofriends")
public class AddToFriendsServlet extends HttpServlet {

    @EJB
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String myEmail = request.getParameter("myEmail");
        String uEmail = request.getParameter("uEmail");

        userBean.addToFriends(myEmail, uEmail);

        request.setAttribute("myEmail", myEmail);
        request.getRequestDispatcher("getusers").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
