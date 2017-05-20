import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Employee;
import entity.Message;
import entity.Organization;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

/**
 * Created by martin on 5/20/17.
 */
public class addEmployee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Employee.updateEmployeeById(request.getParameter("id").toString(),request.getParameter("username").toString(),
                    request.getParameter("password").toString(),request.getParameter("name").toString(),request.getParameter("department".toString()),
                    request.getParameter("title").toString(),request.getParameter("phone").toString(),request.getParameter("landlinephone").toString(),
                    request.getParameter("email").toString(),"//");
        }catch(Exception e){
        }
        try{
            Organization org= Organization.getOrganizationById(request.getParameter("orgid").toString());
            Employee emp=Employee.addEmployee(request.getParameter("username").toString(),
                    request.getParameter("password").toString(),request.getParameter("name").toString(),request.getParameter("department".toString()),
                    request.getParameter("title").toString(),request.getParameter("phone").toString(),request.getParameter("landlinephone").toString(),
                    request.getParameter("email").toString(),"//");
            emp.AttachToOrganization(org,true);
            emp.UpdateMyself();
        }catch (Exception e){}


        request.getRequestDispatcher("getOrganization_employee").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}