package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by martin on 5/13/2017.
 */
public class UserGroup {
    private String id;
    private String description;
    private static SessionFactory factory = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();

    public UserGroup(){}
    public UserGroup(String description){this.description=description;}

    public static UserGroup createUserGroup(String description){
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        UserGroup group=new UserGroup(description);
        session.persist(group);
        session.getTransaction().commit();
        return group;

    }
    public static UserGroup getUserGroupByDescription(String description)
    {
        Session session = factory.getCurrentSession();
        Transaction t=session.beginTransaction();
        Query query=session.createQuery("from UserGroup where description = '" +description+"'");

        List<UserGroup> users=query.list();





        Iterator<UserGroup> iter=users.iterator();
        if(iter.hasNext()) return iter.next();
        else return null;

    }
    public void AttachUser(User user)
    {
        user.getMyUserGroup().add(this);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
