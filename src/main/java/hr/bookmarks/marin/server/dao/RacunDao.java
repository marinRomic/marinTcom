package hr.bookmarks.marin.server.dao;

import hr.bookmarks.marin.server.model.Racun;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RacunDao extends CrudRepository<Racun, Long> {

    public Optional<Racun> findRacunByKorisnickoIme(String korisnickoIme);
}
