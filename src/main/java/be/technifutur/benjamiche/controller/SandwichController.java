package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.form.PanierForm;
import be.technifutur.benjamiche.form.SandwichForm;
import be.technifutur.benjamiche.model.dto.SandwichDTO;
import be.technifutur.benjamiche.service.PanierService;
import be.technifutur.benjamiche.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;
    private final PanierService panierService;

    public SandwichController(SandwichService sandwichService, PanierService panierService) {
        this.sandwichService = sandwichService;
        this.panierService = panierService;
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

    @PostMapping("/add")
    public void addSandwichToPanier(@RequestBody PanierForm panierForm, Authentication authentication){
        panierService.addSandwichToPanier(panierForm.getSandwichId(), panierForm, authentication);
    }

}
