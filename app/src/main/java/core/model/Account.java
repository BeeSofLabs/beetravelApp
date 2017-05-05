package core.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ary on 4/6/17.
 */

public class Account extends RealmObject{
    @PrimaryKey
    private long id;
    private String username;
    private String fullName;
    private String password_hash;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
