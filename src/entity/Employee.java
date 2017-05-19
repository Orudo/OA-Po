package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by martin on 17-4-24.
 */
public class Employee extends User {
    //String loginAccount;
    String Identity;

    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String identity) {
        Identity = identity;
    }

    String Name;
    String department;
    String title;
    String phone;
    String landlinePhone;
    String email;
    String photoPath;
    private  Organization organization;
    private static SessionFactory factory=new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();
    public static Employee addEmployee(String userName,String passwd,String name,String department,String title,String phone,String  landlinePhone,String email,String photoPath){
        Session session = factory.openSession();
        Transaction t=session.beginTransaction();
        Employee employee=new Employee(userName,passwd,name,department,title,phone,landlinePhone,email,photoPath);
        session.persist(employee);
        t.commit();
        session.close();
        return employee;
    }
    public Employee(){}
    public Employee(String userName,String passwd,String name,String department,String title,String phone,String  landlinePhone,String email,String photoPath){
        super(userName,passwd);
        this.Name=name;
        this.department=department;
        this.title=title;
        this.phone=phone;
        this.landlinePhone=landlinePhone;
        this.email=email;
        this.photoPath=photoPath;
    }

    public static Employee GetEmployeeById(String id)
    {
        Session session=factory.getCurrentSession();
        Query query=session.createQuery("from User where id = '" +id+"'");

        List<Employee> users=query.list();

        Transaction t=session.beginTransaction();
        t.commit();
        if (users.iterator().hasNext())
        {
            return users.iterator().next();
        }else return null;
    }
    public void AttachToOrganization(Organization organization,boolean isSetOrganization)
    {
        this.organization=organization;
        if(isSetOrganization){
            organization.getEmployees().add(this);
        }
    }
    public static Employee getEmployeeByName(String userName)
    {
        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from User where userName = '" +userName+"'");

        List<Employee> users=query.list();

        Transaction t=session.beginTransaction();
        t.commit();
        session.close();

        Iterator<Employee> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;
    }


    public static void DelEmployeeById(String id)
    {
        Session session=factory.getCurrentSession();
        Employee employee=session.load(Employee.class,id);
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
    }
    public static void DelEmployeeByEntity(Employee employee)
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
    }

    public static void UpdateEmployee(Employee employee)
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }
    public void UpdateMyself()
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.update(this);
        session.getTransaction().commit();
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLandlinePhone() {
        return landlinePhone;
    }

    public void setLandlinePhone(String landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
