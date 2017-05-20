import com.google.common.hash.Hashing;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by martin on 5/10/17.
 */
public class LoginProcess extends HttpServlet {
    public void init() throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        User user=User.getUser(request.getParameter("username"));
        if (user!=null&&Hashing.sha256().hashString(request.getParameter("password").toString(), StandardCharsets.UTF_8).toString().equals(user.getPasswd())){
            HttpSession session=request.getSession();
            session.setAttribute("userId",user.getId());
            System.out.println("Login Success!");
            request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/index.html").forward(request,response);
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
