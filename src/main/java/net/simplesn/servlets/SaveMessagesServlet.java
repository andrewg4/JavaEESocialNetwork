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
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Andrew on 08.07.2015.
 */
@WebServlet(name = "SaveMessagesServlet", urlPatterns = "savemessages")
public class SaveMessagesServlet extends HttpServlet {

    @EJB
    MessageBean messageBean;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String to = request.getParameter("to");
        String msgsData = request.getParameter("hiddenValue");
        msgsData = msgsData.substring(0, msgsData.length()-1);
        String[] messages = msgsData.split("BBB");

        for (String s : messages) {
            String[] msg = s.split(",");
            messageBean.add(new MessagesVo(msg[0], to, msg[2], new Timestamp(new Date().getTime())));
        }

        request.getRequestDispatcher("getusers").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
