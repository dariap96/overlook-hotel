package itmo.com.overlook.hotel.entities;

import itmo.com.overlook.hotel.entities.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "count_people")
    private Integer countPeople;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "price")
    private Double price;

    @NotNull
    @Column(name = "status", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid")
    private User clientid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getClientid() {
        return clientid;
    }

    public void setClientid(User clientid) {
        this.clientid = clientid;
    }

}