package be.technifutur.benjamiche.service;

import be.technifutur.benjamiche.form.LoginForm;
import be.technifutur.benjamiche.form.RegistrationForm;
import be.technifutur.benjamiche.jwt.JWTHolderDTO;

public interface AuthService {

    void register(RegistrationForm form);

    JWTHolderDTO login(LoginForm form);

}
