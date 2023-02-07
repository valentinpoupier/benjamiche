package be.technifutur.benjamiche.repository;

import be.technifutur.benjamiche.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
