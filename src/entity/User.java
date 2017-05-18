package entity;

import com.google.common.hash.Hashing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/**
 * Created by martin on 17-4-24.
 */
public class User {
    String id;
    String userName;
    String passwd;
    private static SessionFactory factory = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();


    public static User getUser(String userName)
    {

        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from User where userName = '" +userName+"'");

        List<User> users=query.list();


        Transaction t=session.beginTransaction();
        t.commit();
        session.close();

        Iterator<User> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;
    }
    public static User getUserById(String id)
    {
        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from User where id = '" +id+"'");

        List<User> users=query.list();

        Transaction t=session.beginTransaction();
        t.commit();
        session.close();

        Iterator<User> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;
    }
    public User(){}
    public User(String userName,String passwd)
    {
        this.passwd=Hashing.sha256().hashString(passwd, StandardCharsets.UTF_8).toString();
        this.userName=userName;
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
}
