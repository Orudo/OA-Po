package entity;

import java.util.Set;

/**
 * Created by martin on 5/8/17.
 */
public class NewsSet {
    private String id;
    private Set<News> mySet;
    private String description;

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

    public Set<News> getMySet() {
        return mySet;
    }

    public void setMySet(Set<News> mySet) {
        this.mySet = mySet;
    }
}
