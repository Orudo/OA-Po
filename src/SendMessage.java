import entity.Message;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by martin on 5/14/17.
 */
public class SendMessage extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        //request.setAttribute("Message", Message.getMessageFromId(request.getParameter("messageid").toString()));
        //request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/MessageDetail.jsp").forward(request,response);
        Message.addNewMessage(User.getUserById(request.getSession().getAttribute("userId").toString()).getUserName(),request.getParameter("to"),request.getParameter("text"));
        System.out.println("new Message add Success");
        request.getRequestDispatcher("/servlet/getMessage").forward(request,response);
    }}
