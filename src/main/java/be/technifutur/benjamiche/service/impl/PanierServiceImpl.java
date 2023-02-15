package be.technifutur.benjamiche.service.impl;

import be.technifutur.benjamiche.form.PanierForm;
import be.technifutur.benjamiche.model.dto.PanierDTO;
import be.technifutur.benjamiche.model.entity.Commande;
import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import be.technifutur.benjamiche.repository.CommandeRepository;
import be.technifutur.benjamiche.repository.PanierRepository;
import be.technifutur.benjamiche.repository.SandwichRepository;
import be.technifutur.benjamiche.repository.UserRepository;
import be.technifutur.benjamiche.service.PanierService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PanierServiceImpl implements PanierService {

    private final PanierRepository panierRepository;
    private final UserRepository userRepository;

    private final SandwichRepository sandwichRepository;

    private final CommandeRepository commandeRepository;

    public PanierServiceImpl(PanierRepository panierRepository, UserRepository userRepository, SandwichRepository sandwichRepository, CommandeRepository commandeRepository) {
        this.panierRepository = panierRepository;
        this.userRepository = userRepository;
        this.sandwichRepository = sandwichRepository;
        this.commandeRepository = commandeRepository;
    }

    @Override
    public void addSandwichToPanier(PanierForm panierForm, Authentication authentication) {
        Panier panier1 = panierRepository.findById(userRepository.findByUsername(authentication.getName()).get().getPanier().getId()).get();
        List<Sandwich> sandwiches = panier1.getSandwiches();
        sandwiches.add(sandwichRepository.findById(panierForm.getSandwichId()).orElseThrow());
        panier1.setSandwiches(sandwiches);
        panier1.setQuantity(panierForm.getQuantity());
        panier1.setTotal(panier1.getTotal() + sandwichRepository.findById(panierForm.getSandwichId()).get().getPrice() * panierForm.getQuantity());
        panier1.setUser(userRepository.findByUsername(authentication.getName()).get());
        panierRepository.save(panier1);
    }

    @Override
    public void removeSandwichFromPanier(long sandwichId, int quantity) {
        Panier panier = panierRepository.findById(sandwichId).get();
        Sandwich sandwich = sandwichRepository.findById(sandwichId).get();
        panier.setTotal(panier.getTotal() - sandwich.getPrice() * quantity);
        panierRepository.save(panier);
    }

    @Override
    public PanierDTO getPanier(Authentication authentication) {
        Panier panier = panierRepository.findById(userRepository.findByUsername(authentication.getName()).get().getPanier().getId()).get();
        return PanierDTO.from(panier);
    }

    @Override
    public void validatePanier(Authentication authentication) {
        Panier panier = panierRepository.findById(userRepository.findByUsername(authentication.getName()).get().getPanier().getId()).get();
        List<Sandwich> sandwiches = new ArrayList<>(panier.getSandwiches());
        Commande commande = new Commande();
        commande.setDate(LocalDateTime.now());
        commande.setSandwiches(sandwiches);
        commande.setDiscount(0);
        commande.setState("En cours");
        commande.setTotal(panier.getTotal());
        commande.setUser(userRepository.findByUsername(authentication.getName()).get());
        commandeRepository.save(commande);
        panier.setSandwiches(new ArrayList<>());
        panier.setQuantity(0);
        panier.setTotal(0);
        panierRepository.save(panier);
    }
}
