package itmo.com.overlook.hotel.entities;

import itmo.com.overlook.hotel.entities.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String name;

    @NotNull
    @Column(name = "room_count", nullable = false)
    private Integer roomCount;

    @NotNull
    @Column(name = "stage_count", nullable = false)
    private Integer stageCount;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directorid", nullable = false)
    private User directorid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getStageCount() {
        return stageCount;
    }

    public void setStageCount(Integer stageCount) {
        this.stageCount = stageCount;
    }

    public User getDirectorid() {
        return directorid;
    }

    public void setDirectorid(User directorid) {
        this.directorid = directorid;
    }

}