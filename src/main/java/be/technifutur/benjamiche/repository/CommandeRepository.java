package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
