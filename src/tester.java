import com.google.common.hash.Hashing;
import entity.Employee;
import entity.Message;
import entity.Organization;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * Created by martin on 5/1/17.
 */
public class tester {
    private static SessionFactory factory;
    public static void main(String[] args)
    {


        /*Employee e2=new Employee();
        e2.setName("pp");

        Organization o1=new Organization();
        o1.setCode("32767");

        Privilege p1=new Privilege();
        //p1.setMyPrivilege("010");
        p1.setMyPrivilege(enums.Privileges.delete);

        Map<Integer,Privilege> map;
        map=new HashMap<Integer,Privilege>();

        map.put(113,p1);

        o1.setPrivilegeManager(map);

        Set<Employee> e_set=new HashSet<Employee>();
        e_set.add(e1);
        e_set.add(e2);

        o1.setEmployees(e_set);

        Set<Organization> set_organization=new HashSet<Organization>();
        Organization o2=new Organization();
        set_organization.add(o2);
        o1.setSubOrganizations(set_organization);

        o2.setParentOrganization(o1);

        News news=new News();
        news.setAuditor(13);
        news.setTitle("FUCK");

        Attachment attachment=new Attachment();
        attachment.setFilePath("where?");

        Set<Attachment> set4 =new HashSet<Attachment>();
        set4.add(attachment);

        news.setAttachments(set4);

        Set<News> set3=new HashSet<News>();
        set3.add(news);



        //o1.setNews(set3);



        //document libraries test
        DocumentLibrary library=new DocumentLibrary();
        library.setDescription("No des");

        Document document=new Document();
        document.setFilePath("ss");

        Set<Document> documents=new HashSet<Document>();
        documents.add(document);
        library.setDocuments(documents);
        Set<DocumentLibrary> libraries=new HashSet<DocumentLibrary>();
        libraries.add(library);

        o1.setDocumentLibraries(libraries);
        //over


        //ANNOUNCEMENT
        Announcement announcement=new Announcement();
        announcement.setDescription("my des");
        Set<Announcement> announcements=new HashSet<Announcement>();
        announcements.add(announcement);
        o1.setAnnouncements(announcements);

        //over

        //message test

        Message message=new Message();
        message.setReceiver("who");*/







        /*Message message=new Message();
        message.setReceiver("admin");
        message.setFilePath("damnit");*/

        //Employee.addEmployee("martin","123456","martin","damnit","master","131-0000-0000","192,--0029","a@qq.com","//");
        Organization organization=Organization.addOrganization("damnit","123-321","no rank",(float)321.4,"i","1230-3210");
        System.out.println(organization);
        Employee employee=Employee.getEmployeeByName("martin");
        System.out.println(employee);
        employee.AttachToOrganization(organization,true);
        employee.UpdateMyself();
        organization.UpdateMyself();



    }
}
