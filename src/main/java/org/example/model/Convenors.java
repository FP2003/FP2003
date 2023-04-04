package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Convenors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToMany(mappedBy = "convenors")
    private List<Modules> modules = new ArrayList<>();

    public Convenors() {}

    public Convenors(String name, Position position) {
        this.name = name;
        this.position = position;
        this.modules = new ArrayList<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Position {
        GTA,
        LECTURER,
        PROFESSOR
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void removeModule(Modules module) {
        modules.remove(module);
    }
}
