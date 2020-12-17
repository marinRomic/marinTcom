package hr.bookmarks.marin.server.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "KORISNICI")
public class Korisnik {
    private Long id;
    private String ime;
    private String prezime;
    private String eMail;
    private List<Racun> racun;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IME", nullable = false, length = 128)
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Basic
    @Column(name = "PREZIME", nullable = false, length = 128)
    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 128)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(id, korisnik.id) &&
                Objects.equals(ime, korisnik.ime) &&
                Objects.equals(prezime, korisnik.prezime) &&
                Objects.equals(eMail, korisnik.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, eMail);
    }

    @OneToMany(mappedBy = "korisnik")
    public List<Racun> getRacuni() {
        return racun;
    }

    public void setRacuni(List<Racun> racun) {
        this.racun = racun;
    }
}
