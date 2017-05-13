import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.Iterator;
import java.util.List;

/**
 * Created by martin on 17-4-24.
 */
public class User {
    int id;
    String userName;
    String passwd;


    public static User getUser(String userName)
    {

        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from User where userName = '" +userName+"'");

        List<User> users=query.list();

        System.out.println(users.toArray());

        Transaction t=session.beginTransaction();
        t.commit();
        session.close();

        Iterator<User> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
