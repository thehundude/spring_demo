package group.helixlab.spring_demo.movie;

import javax.persistence.*;

@Entity
public class Movie {

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true, updatable = false, insertable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = true, updatable = true, insertable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "type", nullable = true, updatable = true, insertable = true, length = 255)
    private String type;

    @Basic
    @Column(name = "length", nullable = true, updatable = true, insertable = true)
    private int length;

    @Basic
    @Column(name = "age_limit", nullable = true, updatable = true, insertable = true)
    private int ageLimit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }
}
