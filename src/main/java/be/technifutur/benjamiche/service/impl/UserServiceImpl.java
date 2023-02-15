package be.technifutur.benjamiche.service.impl;



import be.technifutur.benjamiche.form.PanierForm;
import be.technifutur.benjamiche.model.entity.Panier;
import be.technifutur.benjamiche.model.entity.Sandwich;
import be.technifutur.benjamiche.repository.PanierRepository;
import be.technifutur.benjamiche.repository.SandwichRepository;
import be.technifutur.benjamiche.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
