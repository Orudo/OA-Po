import javax.print.Doc;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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
    Map<Integer,Privilege> privilegeManager;
    Set<Employee> employees;
    Set<Organization> subOrganizations;
    Set<NewsLibrary> newsLibraries;
    Set<DocumentLibrary> documentLibraries;
    Set<Announcement> announcements;


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
