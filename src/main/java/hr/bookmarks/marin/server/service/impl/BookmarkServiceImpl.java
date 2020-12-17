package hr.bookmarks.marin.server.service.impl;

import hr.bookmarks.marin.server.dao.BookmarkDao;
import hr.bookmarks.marin.server.model.Bookmark;
import hr.bookmarks.marin.server.model.Racun;
import hr.bookmarks.marin.server.model.enums.DaNeEnum;
import hr.bookmarks.marin.server.service.BookmarkService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkDao bookmarkDao;

    @Override
    @PreAuthorize("#username == authentication.principal.username")
    public Bookmark saveBookmark(Bookmark bookmark, String username) {
        return bookmarkDao.save(bookmark);
    }

    @Override
    public List<Bookmark> findBookmarksByRacun(Racun racun) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean isUlogiraniKorisnik = userDetails.equals(racun.getUserDetails());
        DaNeEnum prikaziPrivatneBookmarke = isUlogiraniKorisnik ? DaNeEnum.DA : DaNeEnum.NE;

        return bookmarkDao.findBookmarkByRacunAndJavni(racun, prikaziPrivatneBookmarke);
    }
}
