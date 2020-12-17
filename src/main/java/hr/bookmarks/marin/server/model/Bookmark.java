package hr.bookmarks.marin.server.model;

import hr.bookmarks.marin.server.model.enums.DaNeEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BOOKMARKS")
public class Bookmark {

    private Long id;
    private String link;
    private String naziv;
    private DaNeEnum javni;
    private Racun racun;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LINK", nullable = false, length = 128)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "NAZIV", nullable = false, length = 256)
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Basic
    @Column(name = "JAVNI", nullable = false)
    public DaNeEnum getJavni() {
        return javni;
    }

    public void setJavni(DaNeEnum javni) {
        this.javni = javni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookmark bookmarks = (Bookmark) o;
        return Objects.equals(id, bookmarks.id) &&
                Objects.equals(link, bookmarks.link) &&
                Objects.equals(naziv, bookmarks.naziv) &&
                Objects.equals(javni, bookmarks.javni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link, naziv, javni);
    }

    @ManyToOne
    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
}
