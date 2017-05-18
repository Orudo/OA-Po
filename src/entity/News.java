package entity;

import enums.NewsStatuses;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by martin on 5/7/17.
 */
public class News {
    private String id;
    private String title;
    private String category;

    private String filePath;
    private String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    private String auditor;
    private Date publishDate;
    private Date lastUpdate;
    //private Organization organization;
    private Set<Attachment> attachments;
    //public enum statuses{waitingForReview,passed,notPassed,edited,reviewing}
    private NewsStatuses status;
    private Map<Integer,Privilege> privileges;

    public NewsStatuses getStatus() {
        return status;
    }

    public void setStatus(NewsStatuses status) {
        this.status = status;
    }

    public Map<Integer, Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Map<Integer, Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }
}
