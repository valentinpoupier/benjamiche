package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.model.dto.PanierDTO;
import be.technifutur.benjamiche.service.PanierService;
import be.technifutur.benjamiche.service.SandwichService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/panier")
public class PanierController {
    private final SandwichService sandwichService;
    private final PanierService panierService;

    public PanierController(SandwichService sandwichService, PanierService panierService) {
        this.sandwichService = sandwichService;
        this.panierService = panierService;
    }

    @GetMapping("/view")
    public PanierDTO getPanier(Authentication authentication){
        return panierService.getPanier(authentication);
    }

    @PostMapping("/validate")
    public void validatePanier(Authentication authentication){
        panierService.validatePanier(authentication);
    }
}
