package itmo.com.overlook.hotel.entities;

import itmo.com.overlook.hotel.entities.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromclientid")
    private User fromclientid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toclientid")
    private User toclientid;

    @NotNull
    @Column(name = "info", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFromclientid() {
        return fromclientid;
    }

    public void setFromclientid(User fromclientid) {
        this.fromclientid = fromclientid;
    }

    public User getToclientid() {
        return toclientid;
    }

    public void setToclientid(User toclientid) {
        this.toclientid = toclientid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}