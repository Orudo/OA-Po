import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by martin on 5/18/17.
 */
public class GetOrganizationEntry_Employee extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("enter get orga entry do get");
        request.setAttribute("parentOrganization","null");
        request.getRequestDispatcher("/servlet/getOrganization_employee").forward(request,response);

    }
}
