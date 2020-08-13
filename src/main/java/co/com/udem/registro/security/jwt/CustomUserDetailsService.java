package co.com.udem.registro.security.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import co.com.udem.registro.repositories.RegistroUsuarioRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private RegistroUsuarioRepository users;

    public CustomUserDetailsService(RegistroUsuarioRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        return this.users.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }
}
