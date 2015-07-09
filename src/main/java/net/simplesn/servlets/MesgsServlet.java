package net.simplesn.servlets;

import net.simplesn.bean.MessageBean;
import net.simplesn.vo.MessagesVo;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrew on 08.07.2015.
 */
@WebServlet(name = "MesgsServlet",  urlPatterns = {"getmessages"})
public class MesgsServlet extends HttpServlet {

    @EJB
    MessageBean messageBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MessagesVo> listOfMsgs = messageBean.getAll();
        request.setAttribute("messages", listOfMsgs);

        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
