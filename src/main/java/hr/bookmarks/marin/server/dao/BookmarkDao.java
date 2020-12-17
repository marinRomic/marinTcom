package hr.bookmarks.marin.server.dao;

import hr.bookmarks.marin.server.model.Bookmark;
import hr.bookmarks.marin.server.model.Racun;
import hr.bookmarks.marin.server.model.enums.DaNeEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookmarkDao extends CrudRepository<Bookmark, Long> {

    public List<Bookmark> findBookmarkByRacunAndJavni(Racun racun, DaNeEnum javni);

    public List<Bookmark> findBookmarkByRacun(Racun racun);
}
