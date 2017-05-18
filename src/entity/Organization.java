package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Created by martin on 17-4-24.
 */
public class Organization {
    String id;
    String name;
    String Code;
    String Rank;
    Date inceptionDate;
    float registerFund;
    String leader;
    String faxNumber;
    Map<Integer, Privilege> privilegeManager;
    Set<Employee> employees;
    Set<Organization> subOrganizations;
    Set<NewsLibrary> newsLibraries;
    Set<DocumentLibrary> documentLibraries;
    Set<Announcement> announcements;
    private static SessionFactory factory = new Configuration().configure("entity/hibernate.cfg.xml").buildSessionFactory();

    public static Organization addOrganization(String name, String Code, String Rank, float registerFund, String leader, String faxNumber) {
        Session session = factory.getCurrentSession();
        Organization organization = new Organization();
        organization.setName(name);
        organization.setCode(Code);
        organization.setRank(Rank);
        organization.setInceptionDate(new Date());
        organization.setLeader(leader);
        organization.setFaxNumber(faxNumber);
        organization.setSubOrganizations(new HashSet<Organization>());
        organization.setPrivilegeManager(new HashMap<Integer, Privilege>());
        organization.setEmployees(new HashSet<Employee>());
        organization.setNewsLibraries(new HashSet<NewsLibrary>());
        organization.setDocumentLibraries(new HashSet<DocumentLibrary>());
        organization.setAnnouncements(new HashSet<Announcement>());

        session.beginTransaction();
        session.persist(organization);
        session.getTransaction().commit();
        return organization;

    }

    public void AttachEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void AttachNewsLibrary(NewsLibrary lib) {
        newsLibraries.add(lib);
    }

    public void AttachDocumentLibrary(DocumentLibrary lib) {
        documentLibraries.add(lib);
    }
    public void AttachAnnouncement(Announcement announcement)
    {
        announcements.add(announcement);
    }
    public void AttachSubOrganization(Organization organization){subOrganizations.add(organization);}

    public void DeatchEmployee(Employee employee){employees.remove(employee);}
    public void DeatchNewsLibrary(NewsLibrary lib) {
        newsLibraries.remove(lib);
    }

    public void DeatchDocumentLibrary(DocumentLibrary lib) {
        documentLibraries.remove(lib);
    }
    public void DeatchAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
    }
    public void DetachSubOrganization(Organization organization)
    {
        subOrganizations.remove(organization);
    }
    public void UpdateMyself()
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.update(this);
        session.getTransaction().commit();
    }
    public void DeleteMyself()
    {
        Session session=factory.getCurrentSession();
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
    }

    public Set<NewsLibrary> getNewsLibraries() {
        return newsLibraries;
    }

    public void setNewsLibraries(Set<NewsLibrary> newsLibraries) {
        this.newsLibraries = newsLibraries;
    }

    public Set<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Set<DocumentLibrary> getDocumentLibraries() {
        return documentLibraries;
    }

    public void setDocumentLibraries(Set<DocumentLibrary> documentLibraries) {
        this.documentLibraries = documentLibraries;
    }



    Organization parentOrganization;

    public Organization getParentOrganization() {
        return parentOrganization;
    }

    public void setParentOrganization(Organization parentOrganization) {
        this.parentOrganization = parentOrganization;
    }

    public Set<Organization> getSubOrganizations() {
        return subOrganizations;
    }

    public void setSubOrganizations(Set<Organization> subOrganizations) {
        this.subOrganizations = subOrganizations;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public Date getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(Date inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public float getRegisterFund() {
        return registerFund;
    }

    public void setRegisterFund(float registerFund) {
        this.registerFund = registerFund;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Map<Integer, Privilege> getPrivilegeManager() {
        return privilegeManager;
    }

    public void setPrivilegeManager(Map<Integer, Privilege> privilegeManager) {
        this.privilegeManager = privilegeManager;
    }
}
