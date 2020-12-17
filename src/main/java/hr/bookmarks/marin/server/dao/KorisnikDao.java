package hr.bookmarks.marin.server.dao;

import hr.bookmarks.marin.server.model.Korisnik;
import org.springframework.data.repository.CrudRepository;

public interface KorisnikDao extends CrudRepository<Korisnik, Long> {

    public Korisnik findKorisnikByeMail(String eMail);

}
