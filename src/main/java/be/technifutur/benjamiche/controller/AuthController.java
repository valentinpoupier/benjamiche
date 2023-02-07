package be.technifutur.benjamiche.controller;

import be.technifutur.benjamiche.form.LoginForm;
import be.technifutur.benjamiche.form.RegistrationForm;
import be.technifutur.benjamiche.jwt.JWTHolderDTO;
import be.technifutur.benjamiche.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService userService;

    public AuthController(AuthService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegistrationForm form) {
        userService.register(form);
    }

    @PostMapping("/sign_in")
    public JWTHolderDTO login(@RequestBody @Valid LoginForm form) {
        return userService.login(form);
    }

}
