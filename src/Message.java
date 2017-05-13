import java.util.Date;

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
}
