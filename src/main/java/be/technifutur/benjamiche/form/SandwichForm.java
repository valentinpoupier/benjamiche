package be.technifutur.benjamiche.form;

import be.technifutur.benjamiche.exceptions.ResourceNotFoundException;
import be.technifutur.benjamiche.model.entity.Ingredient;
import be.technifutur.benjamiche.model.entity.Sandwich;
import be.technifutur.benjamiche.repository.DietRepository;
import be.technifutur.benjamiche.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class SandwichForm {

    private final DietRepository dietRepository;
    private final IngredientRepository ingredientRepository;

        private String name;
        private String description;
        private double price;
        private long dietId;
        private Set<Long> ingredients;


        public Sandwich toEntity(){
            Sandwich sandwich = new Sandwich();
            sandwich.setName( this.name );
            sandwich.setDescription( this.description );
            sandwich.setPrice( this.price );
            return sandwich;
        }
}
