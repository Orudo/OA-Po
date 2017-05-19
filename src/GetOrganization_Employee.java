import entity.Message;
import entity.Organization;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by martin on 5/18/17.
 */
public class GetOrganization_Employee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("enter get orga");
        System.out.println(request.getAttribute("parentOrganization").toString());
        List<Organization> organizations=Organization.findOrganizationByParentId(request.getAttribute("parentOrganization").toString());
        request.setAttribute("organizations",organizations);
        request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/EmployeeManager.jsp").forward(request,response);
    }
}
