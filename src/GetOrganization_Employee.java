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

/**
 * Created by martin on 5/18/17.
 */
public class GetOrganization_Employee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        System.out.println("enter get orga");
        //System.out.println(request.getAttribute("organizationId").toString());
        String parid;
        try{
           parid=request.getAttribute("organizationId").toString();
        }catch (Exception e){parid=request.getParameter("organizationId").toString();}
        //==null?request.getParameter("organizationId".toString()):request.getAttribute("organizationId").toString()
        List<Organization> organizations=Organization.findOrganizationByParentId(parid);
        request.setAttribute("organizations",organizations);
        Organization org=Organization.getOrganizationById(parid);
        System.out.println(org==null);
        request.setAttribute("currentOrganization",org);
        if(org!=null){ System.out.println(org.getEmployees());request.setAttribute("organizationEmployees",org.getEmployees());}
        System.out.println("goto another manager");
        request.getRequestDispatcher("/startbootstrap-sb-admin-2-gh-pages/pages/EmployeeManager.jsp").forward(request,response);
    }
}
