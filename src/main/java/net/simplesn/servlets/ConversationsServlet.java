package net.simplesn.servlets;

import net.simplesn.bean.MessageBean;
import net.simplesn.bean.UserBean;
import net.simplesn.vo.MessagesVo;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 07.07.2015.
 */
@WebServlet(name = "ConversationsServlet", urlPatterns = "conv")
public class ConversationsServlet extends HttpServlet {

    @EJB
    UserBean userBean;

    @EJB
    MessageBean messageBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("myEmail");
        String friendEmail = request.getParameter("user");

        // init list of messages
        List<MessagesVo> listOfMessages = new ArrayList<>();

        //get all messages from db
        List<MessagesVo> messagesVoList = messageBean.getAll();

        // find messages between {myemail} and {friendEmail}
        for (MessagesVo messagesVo : messagesVoList){
            if ((messagesVo.getFrom().equals(friendEmail) && messagesVo.getTo().equals(email))
                    || (messagesVo.getFrom().equals(email) && messagesVo.getTo().equals(friendEmail))){
                listOfMessages.add(messagesVo);
            }
        }
        request.setAttribute("messages", listOfMessages);
        request.setAttribute("myEmail", email);
        request.setAttribute("emails", friendEmail);


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
