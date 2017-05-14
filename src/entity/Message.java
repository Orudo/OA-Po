package entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by martin on 5/7/17.
 */
public class Message {
    private String id;
    private Date sentdate;
    private String sender;
    private String receiver;
    private boolean isread;
    private String filePath;
    public static List<Message> getMessageForSpecifiedUser(String userName)
    {
        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from Message where receiver = '"+userName+"'");

        List<Message> messages=query.list();
        System.out.println("get message");
        Transaction t=session.beginTransaction();
        t.commit();
        session.close();
        return messages;
    }
    public Message(String from,String to,String filePath)
    {
        this.sender=from;
        this.receiver=to;
        this.filePath=filePath;
        this.sentdate= new Date();
        this.isread=false;
    }
    public Message()
    {}

    public static Message getMessageFromId(String id)
    {
        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();

        Query query=session.createQuery("from Message where id = '"+id+"'");

        List<Message> messages=query.list();
        System.out.println("get one message");
        Transaction t=session.beginTransaction();
        t.commit();
        session.close();
        if(messages.iterator().hasNext())
        {
            System.out.println("has message");
            return messages.iterator().next();
        }else return  null;
        //return messages;
    }
    private  String getdata(){
        return "sender:"+sender+";file:"+filePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSentdate() {
        return sentdate;
    }

    public void setSentdate(Date sentdate) {
        this.sentdate = sentdate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void addNewMessage(String from,String to,String filePath)
    {
        Session session = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction t=session.beginTransaction();

        Message newMessage=new Message(from,to,filePath);
        session.persist(newMessage);

        t.commit();
        session.close();
        System.out.println("message persist success");
    }
}
