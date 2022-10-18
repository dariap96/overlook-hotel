package itmo.com.overlook.hotel.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
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

    public Notification(Integer id, User fromclientid, User toclientid, String info) {
        this.id = id;
        this.fromclientid = fromclientid;
        this.toclientid = toclientid;
        this.info = info;
    }
}
