import com.google.gson.Gson;
import entity.Employee;
import entity.Organization;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by martin on 5/20/17.
 */
public class getEmployee extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fetch data");
        String targetId = request.getParameter("id").toString();
        //Employee.DelEmployeeById(targetId);
        Organization org=Organization.getOrganizationById(targetId);

        Set<Employee> employees= org.getEmployees();
        Gson gson=new Gson();
        Set<String> a=new HashSet<String>();
        Set<Employee> procceed=new HashSet<Employee>();
        Iterator<Employee> iter=employees.iterator();
        while(iter.hasNext())
        {
            procceed.add(new Employee(iter.next()));
        }
        a.add("damn");
        a.add("fuck");
        System.out.println(gson.toJson(a));
        String json=gson.toJson(procceed);
        System.out.println(json);

        response.setContentType("application/json");
// Get the printwriter object from response to write the required json object to the output stream
        PrintWriter out = response.getWriter();
// Assuming your json object is **jsonObject**, perform the following, it will return your json object
        out.print(json);
        out.flush();

    }
}
