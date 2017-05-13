import java.util.Map;
import java.util.Set;

/**
 * Created by martin on 5/8/17.
 */
public class NewsLibrary {
    private String id;
    private Map<String,Set<News>> library;
    private Map<Integer,Privilege> privilegeManager;
    private String description;
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Set<News>> getLibrary() {
        return library;
    }

    public void setLibrary(Map<String, Set<News>> library) {
        this.library = library;
    }

    public Map<Integer, Privilege> getPrivilegeManager() {
        return privilegeManager;
    }

    public void setPrivilegeManager(Map<Integer, Privilege> privilegeManager) {
        this.privilegeManager = privilegeManager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
