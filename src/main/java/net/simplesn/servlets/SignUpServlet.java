package net.simplesn.servlets;

import net.simplesn.bean.UserBean;
import net.simplesn.vo.UserVo;

import javax.ejb.EJB;
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

    @EJB
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get registration data
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // if a user with the registration data doesn't exist, redirect him to login page
        if (userBean.isRegisteredUser(email)){
            request.getRequestDispatcher("failuresignup.jsp").forward(request, response);
        }
        // create new user and add him to the list of users
        else {
            userBean.add(new UserVo(name, password, email, "", "", "", null));
            response.setContentType("text/html;charset=UTF-8");
            request.getRequestDispatcher("successregistration.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
