package entity;

import enums.Privileges;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by martin on 4/27/17.
 */
public class Privilege {
    private String id;
    //public enum privilege{readonly,write,owned,delete}
    private enums.Privileges myPrivilege;
    private static SessionFactory factory = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();

    public Privilege(){}
    public Privilege(boolean isOwn)
    {
        if(isOwn) {myPrivilege= Privileges.owned;}else{myPrivilege=Privileges.readonly;}
    }
    public static Privilege createPrivilege(boolean isOwned){
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        Privilege privilege=new Privilege(isOwned);
        session.persist(privilege);
        session.getTransaction().commit();
        return privilege;
    }
    public boolean checkStatus(Privileges privileges)
    {
        return privileges==this.myPrivilege;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Privileges getMyPrivilege() {
        return myPrivilege;
    }

    public void setMyPrivilege(Privileges myPrivilege) {
        this.myPrivilege = myPrivilege;
    }
}
