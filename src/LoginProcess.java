import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by martin on 5/10/17.
 */
public class LoginProcess extends HttpServlet {
    public void init() throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        User user=User.getUser(request.getParameter("username"));
        if (user!=null&&request.getAttribute("password").equals(user.getPasswd())){
                response.sendRedirect("/startbootstrap-sb-admin-2-gh-pages/pages/index.html");
        }else{
            request.setAttribute("MESSAGE","incorrect_username_password");
            request.setAttribute("username",request.getParameter("username"));
            request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/login.jsp").forward(request,response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{
        doGet(request,response);
    }
}
