package be.technifutur.benjamiche.model.dto;

import be.technifutur.benjamiche.model.entity.Commande;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class CommandeDTO {
    private LocalDateTime date;
    private LocalDateTime dateLivraison;
    private int discount;
    private String status;
    private double payment;
    private List<SandwichDTO> sandwiches;

    @Data
    @Builder
    public static class SandwichDTO {
        private String name;
        private String description;
        private double price;
        private Diet diet;
        private List<Ingredient> ingredients;

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
    }
    public static CommandeDTO from(Commande entity){
        if( entity == null )
            return null;

        return CommandeDTO.builder()
                .date( entity.getDate() )
                .dateLivraison( entity.getDeliveryDate() )
                .discount( entity.getDiscount() )
                .status( entity.getState() )
                .payment( entity.getTotal() )
                .sandwiches( entity.getSandwiches().stream().map( s -> SandwichDTO.builder()
                        .name( s.getName() )
                        .description( s.getDescription() )
                        .price( s.getPrice() )
                        .diet( SandwichDTO.Diet.builder()
                                .id( s.getDiet().getId() )
                                .name( s.getDiet().getName() )
                                .description( s.getDiet().getDescription() )
                                .build()
                        )
                        .ingredients( s.getIngredients().stream().map( i -> SandwichDTO.Ingredient.builder()
                                .id( i.getId() )
                                .name( i.getName() )
                                .build()
                        ).toList() )
                        .build()
                ).toList() )
                .build();
    }
}
