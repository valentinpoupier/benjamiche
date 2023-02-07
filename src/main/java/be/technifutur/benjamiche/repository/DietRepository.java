package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRepository extends JpaRepository<Diet, Long> {
}
