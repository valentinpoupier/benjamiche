package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.form.PanierForm;
import be.technifutur.benjamiche.form.SandwichForm;
import be.technifutur.benjamiche.model.dto.SandwichDTO;
import be.technifutur.benjamiche.repository.UserRepository;
import be.technifutur.benjamiche.service.PanierService;
import be.technifutur.benjamiche.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.security.config.annotation.web.headers.HeadersSecurityMarker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;
    private final PanierService panierService;

    private final UserRepository userRepository;

    public SandwichController(SandwichService sandwichService, PanierService panierService, UserRepository userRepository) {
        this.sandwichService = sandwichService;
        this.panierService = panierService;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<SandwichDTO> getAllSandwiches(){
        return sandwichService.getAll();
    }

    @GetMapping("/{id}")
    public SandwichDTO getOneSandwich(@PathVariable long id){
        return sandwichService.getOne(id);
    }

    @PostMapping("/create")
    public void createSandwich(@RequestBody @Valid SandwichForm form){
        sandwichService.createSandwich(form);
    }

    @PatchMapping("/add")
    public void addSandwichToPanier(Authentication authentication, @RequestBody PanierForm panierForm){
        panierService.addSandwichToPanier(panierForm, authentication);
    }

    @PatchMapping("/{id}/update")
    public void updateSandwich(@PathVariable long id, @RequestBody SandwichForm form){
        sandwichService.updateSandwich(form, id);
    }

}
