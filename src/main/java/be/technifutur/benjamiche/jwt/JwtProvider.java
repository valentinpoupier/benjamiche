package be.technifutur.benjamiche.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtProvider {

    private final UserDetailsService userDetailsService;

    public JwtProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(Authentication auth) {

        Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24));
        try {
            return JWT.create()
                    .withSubject(auth.getName())
                    .withExpiresAt(exp)
                    .withIssuedAt(now)
                    .sign(Algorithm.HMAC512("s3cr3t"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error while creating token");
        }
    }

    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512("s3cr3t"))
                    .acceptExpiresAt(1000 * 60 * 60 * 24)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);

//            String subject = decodedJWT.getSubject();
//            Claim claim = decodedJWT.getClaim("claim_name");
//            return subject.length()>50 && claim.asBoolean();

            return true;
        }catch (JWTVerificationException ex){
            return false;
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error while validating token");
        }
    }

    public Authentication generateAuthentication(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        String username = decodedJWT.getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
    }

}
