package be.technifutur.benjamiche.model.dto;

import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PanierDTO {

    private long id;
    private List<Sandwich> sandwiches;
    private double total;

    public static PanierDTO from(Panier entity){
        if( entity == null )
            return null;

        return PanierDTO.builder()
                .id( entity.getId() )
                .sandwiches( entity.getSandwiches() )
                .total( entity.getTotal() )
                .build();
    }


}
