package net.simplesn.servlets;

import net.simplesn.bean.UserBean;
import net.simplesn.vo.UserVo;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Andrew on 30.06.2015.
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"signin"})
public class SignInServlet extends HttpServlet {

    @EJB
    UserBean userBean;

    //HttpSession & cookie lifetime = 24 * 60 * 60 = 86400 (24 hours)
    private static final int MAX_AGE = 86400;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get request parameters for userID and password
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // check if user data is correct
        if (userBean.isRegisteredUser(email)){

            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            //setting session to expiry in 24 hours
            session.setMaxInactiveInterval(MAX_AGE);

            //creating and setting cookie lifetime - expire in 24 hours
//            Cookie user = new Cookie("email", email);
//            user.setMaxAge(MAX_AGE);
//            response.addCookie(user);

            UserVo myProfile = userBean.getProfileData(email);
            request.setAttribute("profile", myProfile);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        // redirect to login page
        else {
            request.getRequestDispatcher("signupin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req, resp);
    }
}
