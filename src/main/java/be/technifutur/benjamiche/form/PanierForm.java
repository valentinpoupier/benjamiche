package be.technifutur.benjamiche.form;

import be.technifutur.benjamiche.model.entity.Sandwich;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierForm {

    private Set<Sandwich> sandwich = new HashSet<>();
    private int quantity;


}
