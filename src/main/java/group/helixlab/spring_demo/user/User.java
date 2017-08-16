package group.helixlab.spring_demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true, updatable = false, insertable = false)
    private int id;

    @Basic
    @Column(name = "user_name", nullable = true, updatable = true, insertable = true, length = 255)
    private String userName;

    @Basic
    @Column(name = "password", nullable = true, updatable = true, insertable = true, length = 255)
    @JsonIgnore
    private String password;

    @Basic
    @Column(name = "enabled", nullable = true, updatable = true, insertable = true, length = 255)
    private boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
