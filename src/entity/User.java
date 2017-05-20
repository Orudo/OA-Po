package entity;

import com.google.common.hash.Hashing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by martin on 17-4-24.
 */
public class User {
    String id;
    String userName;
    String passwd;
    Set<UserGroup> myUserGroup;
    private static SessionFactory factory = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();


    public static User getUser(String userName)
    {

        Session session = factory.getCurrentSession();
        Transaction t=session.beginTransaction();
        Query query=session.createQuery("from User where userName = '" +userName+"'");

        List<User> users=query.list();



        System.out.println("Users list get");

        Iterator<User> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;
    }

    public static User getUserById(String id)
    {
        Session session = factory.getCurrentSession();
        Transaction t=session.beginTransaction();
        Query query=session.createQuery("from User where id = '" +id+"'");

        List<User> users=query.list();





        Iterator<User> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;
    }
    public User(){this.myUserGroup=new HashSet<UserGroup>();}
    public User(String userName,String passwd)
    {

        this.passwd=Hashing.sha256().hashString(passwd, StandardCharsets.UTF_8).toString();
        this.userName=userName;
        this.myUserGroup=new HashSet<UserGroup>();
    }
    public static void addNewUser(String userName,String passwd)
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.persist(new User(userName,passwd));
        session.getTransaction().commit();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Set<UserGroup> getMyUserGroup() {
        return myUserGroup;
    }
    public void UpdateMyself()
    {
        Session session=factory.getCurrentSession();
        session.update(this);
        session.getTransaction().commit();
    }

    public void setMyUserGroup(Set<UserGroup> myUserGroup) {
        this.myUserGroup = myUserGroup;
    }
}
