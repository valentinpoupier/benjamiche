package be.technifutur.benjamiche.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "panier_id")
    private long id;

    @OneToMany
    @JoinTable(
            name = "panier_sandwich",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id")
    )
    @JoinColumn(name = "sandwich_id")
    private List<Sandwich> sandwiches = new ArrayList<>();

    private double total = 0;

    @OneToOne(mappedBy = "panier")
    private User user;

}
