package hr.bookmarks.marin.server.model;

import hr.bookmarks.marin.server.model.enums.DaNeEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "RACUNI")
public class Racun {
    private Long id;
    private String korisnickoIme;
    private String password;
    private DaNeEnum status;
    private Korisnik korisnik;
    private List<Bookmark> bookmarks;

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
    @Column(name = "KORISNICKO_IME", nullable = false, length = 128)
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "STATUS", nullable = true)
    public DaNeEnum getStatus() {
        return status;
    }

    public void setStatus(DaNeEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racun racun = (Racun) o;
        return Objects.equals(id, racun.id) &&
                Objects.equals(korisnickoIme, racun.korisnickoIme) &&
                Objects.equals(password, racun.password) &&
                Objects.equals(status, racun.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, korisnickoIme, password, status);
    }

    @ManyToOne
    @JoinColumn(name = "KORISNIK_ID", referencedColumnName = "ID", nullable = false)
    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @OneToMany(mappedBy = "racun")
    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    @Transient
    public UserDetails getUserDetails() {
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return password;
            }

            @Override
            public String getUsername() {
                return korisnickoIme;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };

        return userDetails;
    }
}
