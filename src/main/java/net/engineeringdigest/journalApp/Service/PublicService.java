package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.DTOs.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    public String verify(LoginDTO dto){
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(),dto.getPassword()));

        boolean result = authentication.isAuthenticated();
        if(result){
            return jwtService.generateToken(dto.getUserName());
        }
        return "Aela Una ruu";
    }
}
