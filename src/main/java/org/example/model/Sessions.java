package org.example.model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String topic;
    private Timestamp datetime;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "module_code")
    private Modules module;

    @OneToMany(mappedBy = "convenors", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Modules> modules = new HashSet<>();


    public Sessions() {
    }

    public Sessions(String topic, Timestamp datetime, int duration) {
        this.topic = topic;
        this.datetime = datetime;
        this.duration = duration;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
