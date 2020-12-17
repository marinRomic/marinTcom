package hr.bookmarks.marin.server.service;

import hr.bookmarks.marin.server.model.Racun;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface RacunService extends UserDetailsService {

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    Racun getUserByUsername(String korisnickoIme) throws UsernameNotFoundException;

    void signUp(Racun racun);
}
