package be.technifutur.benjamiche.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime date;

    @Column(name="delivery_date", nullable = false)
    private LocalDateTime deliveryDate;

    @Column(name="discount", nullable = false)
    private int discount;

    @Column(name="state", nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    private Set<Sandwich> sandwiches = new HashSet<>();
}
