package hr.bookmarks.marin.server.service;

import hr.bookmarks.marin.server.model.Bookmark;
import hr.bookmarks.marin.server.model.Racun;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BookmarkService {
    @PreAuthorize("#username == authentication.principal.username")
    Bookmark saveBookmark(Bookmark bookmark, String username);

    List<Bookmark> findBookmarksByRacun(Racun racun);
}
