package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
}
