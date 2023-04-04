package org.example.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Modules {
    @Id
    private String code;
    private String title;
    private int level;
    private boolean optional;

    public Modules() {}

    public Modules(String code, String title, int level, boolean optional) {
        this.code = code;
        this.title = title;
        this.level = level;
        this.optional = optional;
    }

    @ManyToMany(mappedBy = "modules")
    private Set<Convenors> convenors = new HashSet<>();

    @OneToMany(mappedBy = "module", cascade = CascadeType.REMOVE)
    private Set<Sessions> sessions = new HashSet<>();

    public void removeModule(EntityManager entityManager) {
        // Remove the module from the associated convenors
        for (Convenors convenor : convenors) {
            convenor.removeModule(this);
            entityManager.merge(convenor);
        }
        // Remove the sessions associated with the module
        sessions.clear();
        entityManager.remove(this);
    }

    // Getters And Setters below...

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }
}
