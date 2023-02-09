package be.technifutur.benjamiche.service.impl;

import be.technifutur.benjamiche.form.PanierForm;
import be.technifutur.benjamiche.model.dto.PanierDTO;
import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import be.technifutur.benjamiche.repository.PanierRepository;
import be.technifutur.benjamiche.repository.SandwichRepository;
import be.technifutur.benjamiche.repository.UserRepository;
import be.technifutur.benjamiche.service.PanierService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServiceImpl implements PanierService {

    private final PanierRepository panierRepository;
    private final UserRepository userRepository;

    private final SandwichRepository sandwichRepository;

    public PanierServiceImpl(PanierRepository panierRepository, UserRepository userRepository, SandwichRepository sandwichRepository) {
        this.panierRepository = panierRepository;
        this.userRepository = userRepository;
        this.sandwichRepository = sandwichRepository;
    }

    @Override
    public void addSandwichToPanier(long idSand, PanierForm panierForm, Authentication authentication) {
        Panier panier = userRepository.findByUsername(authentication.getName()).get().getPanier();
        Sandwich sandwich = sandwichRepository.findById(idSand).get();
        List<Sandwich> sandwiches = panier.getSandwiches();
        sandwiches.add(panierForm.toEntity().getSandwiches().get(0));
        sandwiches.add(sandwich);
        panier.setSandwiches(sandwiches);
        panier.setTotal(panier.getTotal() + panierForm.toEntity().getTotal());
        panierRepository.saveAndFlush(panier);
    }

    @Override
    public void removeSandwichFromPanier(long sandwichId, int quantity) {

    }

    @Override
    public PanierDTO getPanier() {
        return null;
    }
}
