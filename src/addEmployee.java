import entity.Employee;
import entity.Message;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by martin on 5/20/17.
 */
public class addEmployee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee.addEmployee(request.getParameter("usrname").toString(), request.getParameter("pwd").toString(), "a", "b", request.getParameter("title").toString(), "c", "d", "e", "f");
        request.getRequestDispatcher("servlet/getOrganization_employee").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}