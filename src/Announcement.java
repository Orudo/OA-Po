import enums.AnnouncementStatuses;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by martin on 5/7/17.
 */
public class Announcement {
    private int id;
    private String Title;
    private Date begin,end,published_date;
    private Organization organization;
    //public enum statuses {waitingForReview,passed,notPassed};
    private AnnouncementStatuses status;
    private String filePath;
    private Set<Attachment> attachments;
    private Map<Integer,Privilege> privilegeManager;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Integer, Privilege> getPrivilegeManager() {
        return privilegeManager;
    }

    public void setPrivilegeManager(Map<Integer, Privilege> privilegeManager) {
        this.privilegeManager = privilegeManager;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public AnnouncementStatuses getStatus() {
        return status;
    }

    public void setStatus(AnnouncementStatuses status) {
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }
}
