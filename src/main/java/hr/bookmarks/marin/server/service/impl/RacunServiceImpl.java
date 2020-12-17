package hr.bookmarks.marin.server.service.impl;

import hr.bookmarks.marin.server.dao.RacunDao;
import hr.bookmarks.marin.server.model.Racun;
import hr.bookmarks.marin.server.service.RacunService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RacunServiceImpl implements RacunService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RacunDao racunDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Racun> optionalRacun = racunDao.findRacunByKorisnickoIme(s);

        if (optionalRacun.isPresent()) {
            return optionalRacun.get().getUserDetails();
        }
        throw new UsernameNotFoundException(MessageFormat.format("Račun s korisničkim imenom {} ne postoji.", s));
    }

    @Override
    public Racun getUserByUsername(String korisnickoIme) throws UsernameNotFoundException {
        Optional<Racun> optionalRacun = racunDao.findRacunByKorisnickoIme(korisnickoIme);

        if (optionalRacun.isPresent()) {
            return optionalRacun.get();
        }
        throw new UsernameNotFoundException(MessageFormat.format("Račun s korisničkim imenom {} ne postoji.", korisnickoIme));
    }

    @Override
    public void signUp(Racun racun) {

        final String encryptedPassword = bCryptPasswordEncoder.encode(racun.getPassword());

        racun.setPassword(encryptedPassword);

        racunDao.save(racun);
    }
}
