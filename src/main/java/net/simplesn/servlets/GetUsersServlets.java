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
import java.util.List;

/**
 * Created by Andrew on 05.07.2015.
 */
@WebServlet(name = "GetUsersServlet",  urlPatterns = {"/getusers"})
public class GetUsersServlets extends HttpServlet {

    @EJB
    UserBean userBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserVo> listOfUsers = userBean.getAll();
        request.setAttribute("users", listOfUsers);

        request.getRequestDispatcher("users.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}