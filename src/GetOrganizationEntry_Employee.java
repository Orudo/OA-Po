import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by martin on 5/18/17.
 */
public class GetOrganizationEntry_Employee extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("enter get orga entry do get");
        Stack<String> organizationIDStack=new Stack<String>();
        organizationIDStack.push("null");
        request.getSession().setAttribute("organizationStack",organizationIDStack);
        request.getRequestDispatcher("/servlet/getOrganization_employee").forward(request,response);

    }
}
