package be.technifutur.benjamiche.service.impl;

import be.technifutur.benjamiche.exceptions.FormValidationException;
import be.technifutur.benjamiche.form.LoginForm;
import be.technifutur.benjamiche.form.RegistrationForm;
import be.technifutur.benjamiche.jwt.JWTHolderDTO;
import be.technifutur.benjamiche.jwt.JwtProvider;
import be.technifutur.benjamiche.model.entity.User;
import be.technifutur.benjamiche.repository.UserRepository;
import be.technifutur.benjamiche.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtProvider jwtProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegistrationForm form) {
        if (userRepository.existsByUsername(form.getUsername())) {
            throw new FormValidationException("Username already exists");
        }
        User user = form.toUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    @Override
    public JWTHolderDTO login(LoginForm form) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        authManager.authenticate(authentication);
        String token = jwtProvider.createToken(authentication);
        return new JWTHolderDTO(token);
    }
}
