package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    @Transactional
    @Modifying
    @Query("update Panier p set p.sandwiches = ?1, p.total = ?2 where p.id = ?3")
    int updateSandwichesAndQuantityAndTotalById(List<Sandwich> sandwiches, double total, long id);
}
