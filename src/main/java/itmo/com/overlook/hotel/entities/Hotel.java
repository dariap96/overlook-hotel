package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    @Size(max = 50)
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

    public Hotel(String name, Integer roomCount, Integer stageCount, User directorid) {
        this.name = name;
        this.roomCount = roomCount;
        this.stageCount = stageCount;
        this.directorid = directorid;
    }
}
