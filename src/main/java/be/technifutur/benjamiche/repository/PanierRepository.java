package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    // add sandwich in panier by id
    @Modifying
    @Transactional
    @Query("UPDATE Panier p SET p.sandwiches = ?2 WHERE p.id = ?1")
    void updateSandwiches(long id, List<Sandwich> sandwiches);
}