import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Employee;
import entity.Message;
import entity.Organization;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by martin on 5/18/17.
 */
public class GetOrganization_Employee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("enter get orga");

        //System.out.println(request.getAttribute("organizationId").toString());
        Stack<String> organizationStack=(Stack<String>)request.getSession().getAttribute("organizationStack");
        try{
            String id=request.getParameter("remove").toString();
            organizationStack.pop();

        }catch (Exception e){}
        try{
            String id=request.getParameter("organizationId").toString();
            organizationStack.push(id);

        }catch (Exception e){}
        String currentid=organizationStack.peek();
        //==null?request.getParameter("organizationId".toString()):request.getAttribute("organizationId").toString()
        List<Organization> organizations=Organization.findOrganizationByParentId(currentid);
        request.setAttribute("organizations",organizations);
        Organization org=Organization.getOrganizationById(currentid);
        request.setAttribute("currentOrganization",org);
        request.setAttribute("currentOrganizationId",org==null?"null":org.getId());
        request.getSession().setAttribute("organizationStack",organizationStack);
        request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/EmployeeManager.jsp").forward(request,response);
    }
}
