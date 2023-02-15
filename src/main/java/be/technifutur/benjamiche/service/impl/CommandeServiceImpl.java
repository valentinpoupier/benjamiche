package be.technifutur.benjamiche.service.impl;

import be.technifutur.benjamiche.model.dto.CommandeDTO;
import be.technifutur.benjamiche.repository.CommandeRepository;
import be.technifutur.benjamiche.service.CommandeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class CommandeServiceImpl implements CommandeService{

    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

        @Override
        public CommandeDTO getCommande(long id, Authentication authentication) {
            return CommandeDTO.from(commandeRepository.findById(id).get());
        }


}
