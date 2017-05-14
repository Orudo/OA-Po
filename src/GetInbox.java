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
public class GetInbox extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.setAttribute("messageLists", Message.getMessageForSpecifiedUser(User.getUserById(request.getSession().getAttribute("userId").toString()).getUserName()));
        request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/MessageInbox.jsp").forward(request,response);
    }
}
