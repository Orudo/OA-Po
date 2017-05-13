import java.util.HashMap;
import java.util.Set;

/**
 * Created by martin on 5/7/17.
 */
public class DocumentLibrary {
    private String id;
    private Organization organization;
    private String description;
    private String catagory;
    private int capacity;
    private int max_limit;
    private Set<Document> documents;
    private HashMap<Integer,Privilege> privilegeManager;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public HashMap<Integer, Privilege> getPrivilegeManager() {
        return privilegeManager;
    }

    public void setPrivilegeManager(HashMap<Integer, Privilege> privilegeManager) {
        this.privilegeManager = privilegeManager;
    }
}
