import enums.Privileges;

/**
 * Created by martin on 4/27/17.
 */
public class Privilege {
    private int id;
    //public enum privilege{readonly,write,owned,delete}
    private enums.Privileges myPrivilege;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Privileges getMyPrivilege() {
        return myPrivilege;
    }

    public void setMyPrivilege(Privileges myPrivilege) {
        this.myPrivilege = myPrivilege;
    }
}
