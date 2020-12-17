package hr.bookmarks.marin.server.service.impl;

import hr.bookmarks.marin.server.dao.KorisnikDao;
import hr.bookmarks.marin.server.model.Korisnik;
import hr.bookmarks.marin.server.service.KorisnikService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikDao korisnikDao;

    @Override
    public void insertKorisnik(Korisnik korisnik) {
        korisnikDao.save(korisnik);
    }

}
