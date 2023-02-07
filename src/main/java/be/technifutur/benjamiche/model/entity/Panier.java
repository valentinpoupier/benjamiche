package be.technifutur.benjamiche.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "panier_id")
    private long id;

    @OneToMany
    private Set<Sandwich> sandwiches = new HashSet<>();

    @OneToOne(mappedBy = "panier")
    private User user;

}
