package be.technifutur.benjamiche.service;

import be.technifutur.benjamiche.model.dto.CommandeDTO;
import org.springframework.security.core.Authentication;

public interface CommandeService {


    CommandeDTO getCommande(long id, Authentication authentication);


}
