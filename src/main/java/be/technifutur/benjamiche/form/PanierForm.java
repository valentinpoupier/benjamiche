package be.technifutur.benjamiche.form;

import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierForm {

    private Map<Sandwich,Integer> sandwiches;

    public Panier toEntity(){
        Panier panier = new Panier();
        panier.setSandwiches( this.sandwiches.keySet() );
        panier.setTotal( this.sandwiches.keySet().stream().mapToDouble( Sandwich::getPrice ).sum() );
        return panier;
    }

}
