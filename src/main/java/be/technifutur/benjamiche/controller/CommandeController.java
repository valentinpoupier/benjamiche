package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.model.dto.CommandeDTO;
import be.technifutur.benjamiche.service.CommandeService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/view/{id}")
    public CommandeDTO getCommande(@PathVariable long id, Authentication authentication){
        return commandeService.getCommande(id, authentication);
    }
}
