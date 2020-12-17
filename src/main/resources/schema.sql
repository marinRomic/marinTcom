
DROP TABLE IF EXISTS `BOOKMARKS`;
DROP TABLE IF EXISTS `RACUNI`;
DROP TABLE IF EXISTS KORISNICI;

create table KORISNICI
(
    ID BIGINT auto_increment,
    IME VARCHAR(128) not null,
    PREZIME VARCHAR(128) not null,
    EMAIL VARCHAR(128) not null
);

create unique index KORISNIK_ID_UINDEX
    on KORISNICI (ID);

alter table KORISNICI
    add constraint KORISNIK_PK
        primary key (ID);

create table RACUNI
(
    ID BIGINT auto_increment,
    KORISNICKO_IME VARCHAR(128) not null,
    PASSWORD VARCHAR(128) not null,
    STATUS INT,
    KORISNIK_ID INT not null,
    constraint RACUNI_PK
        primary key (ID)
);

create table BOOKMARKS
(
    ID BIGINT auto_increment,
    RACUN_ID INT not null,
    LINK VARCHAR(128) not null,
    NAZIV VARCHAR(256) not null,
    JAVNI INT not null,
    constraint BOOKMARKS___FK
        foreign key (RACUN_ID) references RACUNI (ID)
);

create unique index BOOKMARKS_ID_UINDEX
    on BOOKMARKS (ID);

alter table BOOKMARKS
    add constraint BOOKMARKS_PK
        primary key (ID);

create unique index RACUNI_ID_UINDEX
    on RACUNI (ID);


-- create table mydb.public.bookmarks (id bigint not null, javni integer, link varchar(255), naziv varchar(255), racun_id bigint, primary key (id))
-- create table mydb.public.korisnik (id bigint not null, e-mail varchar(255), ime varchar(255), prezime varchar(255), primary key (id))
-- create table mydb.public.racun (id bigint not null, korisnicko_ime varchar(255), korisnik_id bigint, password varchar(255), status integer, primary key (id))
-- alter table mydb.public.bookmarks add constraint FKbnr7gx1ty27ti3ux8hsan176y foreign key (racun_id) references mydb.public.racun
-- alter table mydb.public.bookmarks add constraint FKbnr7gx1ty27ti3ux8hsan176y foreign key (racun_id) references mydb.public.racun
