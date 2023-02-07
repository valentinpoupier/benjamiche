package be.technifutur.benjamiche.model.dto;

import be.technifutur.benjamiche.model.entity.Diet;
import be.technifutur.benjamiche.model.entity.Ingredient;
import be.technifutur.benjamiche.model.entity.Sandwich;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
public class SandwichDTO {

    private String name;
    private String description;
    private double price;
    private Diet diet;
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

    @Data
    @Builder
    public static class Diet {
        private long id;
        private String name;
        private String description;
    }

    @Data
    @Builder
    public static class Ingredient {
        private long id;
        private String name;
    }

    public static SandwichDTO from(Sandwich entity){
        if( entity == null )
            return null;

        return SandwichDTO.builder()
                .name( entity.getName() )
                .description( entity.getDescription() )
                .price( entity.getPrice() )
                .diet( Diet.builder()
                        .id( entity.getDiet().getId() )
                        .name( entity.getDiet().getName() )
                        .description( entity.getDiet().getDescription() )
                        .build()
                )
                .ingredients( entity.getIngredients().stream()
                        .map( i -> Ingredient.builder()
                                .id( i.getId() )
                                .name( i.getName() )
                                .build()
                        )
                        .collect( LinkedHashSet::new, Set::add, Set::addAll ))
                .build();
    }
}
