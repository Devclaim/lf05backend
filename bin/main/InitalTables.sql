CREATE TABLE REGION (
                     REGIONID        INTEGER NOT NULL,
                     PLZ             VARCHAR(5),
                     ORT             VARCHAR(50),
                     PRIMARY KEY (REGIONID)
);

CREATE TABLE ADRESSE (
                      ADRESSID        INTEGER NOT NULL,
                      STRASSE         VARCHAR(50),
                      HAUSNR		  VARCHAR(6),
                      REGIONID        INTEGER NOT NULL,
                      PRIMARY KEY (ADRESSID),
                      FOREIGN KEY (REGIONID) REFERENCES REGION (REGIONID)
);

CREATE TABLE KUNDE (
                    KUNDENNR        INTEGER NOT NULL,
                    NACHNAME        VARCHAR(50),
                    VORNAME         VARCHAR(50),
                    GEBURTSDATUM	DATE,
                    TELEFON         VARCHAR(25),
                    EMAIL           VARCHAR(50),
                    ADRESSID        INTEGER NOT NULL,
                    PRIMARY KEY (KUNDENNR),
                    FOREIGN KEY (ADRESSID) REFERENCES ADRESSE (ADRESSID)
);



CREATE TABLE LIEFERANT (
                        LIEFERANTENNR   INTEGER NOT NULL,
                        LIEFERANTENNAME VARCHAR(50),
                        TELEFON			VARCHAR(25),
                        EMAIL           VARCHAR(50),
                        ADRESSID        INTEGER NOT NULL,
                        PRIMARY KEY (LIEFERANTENNR),
                        FOREIGN KEY (ADRESSID) REFERENCES ADRESSE (ADRESSID)
);


CREATE TABLE BESTELLUNG (
                         BESTELLNR        SERIAL NOT NULL,
                         KUNDENNR         INTEGER,
                         BESTELLDATUM     DATE,
                         RECHNUNGSBETRAG_BRUTTO  DECIMAL(10,2),
                         RECHNUNGSBETRAG_NETTO  DECIMAL(10,2),
                         PRIMARY KEY (BESTELLNR),
                         FOREIGN KEY (KUNDENNR) REFERENCES KUNDE (KUNDENNR)
);



CREATE TABLE ZUTAT (
                    ZUTATNR			    INTEGER NOT NULL,
                    BEZEICHNUNG         VARCHAR(50),
                    EINHEIT             VARCHAR (25),
                    VERKAUFSPREIS       DECIMAL(10,2),
                    EINKAUFSPREIS       DECIMAL(10,2),
                    BESTAND             INTEGER,
                    LIEFERANTENNR		INTEGER,
                    KALORIEN			INTEGER,
                    KOHLENHYDRATE		DECIMAL (10,2),
                    PROTEIN			    DECIMAL(10,2),
                    PRIMARY KEY (ZUTATNR),
                    FOREIGN KEY (LIEFERANTENNR) REFERENCES LIEFERANT (LIEFERANTENNR)
);



CREATE TABLE BESTELLUNGZUTAT (
                                 BESTELLNR       INTEGER NOT NULL,
                                 ZUTATNR       INTEGER,
                                 MENGE     		INTEGER,
                                 FOREIGN KEY (BESTELLNR) REFERENCES BESTELLUNG (BESTELLNR),
                                 FOREIGN KEY (ZUTATNR) REFERENCES ZUTAT (ZUTATNR)
);



CREATE TABLE EIGENSCHAFTEN (
                             EIGENSCHAFTID    INTEGER NOT NULL,
                             BEZEICHNUNG       VARCHAR(50),
                             PRIMARY KEY (EIGENSCHAFTID)
);



CREATE TABLE ZUTATEIGENSCHAFT (
                               ZUTATNR            INTEGER NOT NULL,
                               EIGENSCHAFTID      INTEGER NOT NULL,
                               FOREIGN KEY (ZUTATNR) REFERENCES ZUTAT (ZUTATNR),
                               FOREIGN KEY (EIGENSCHAFTID) REFERENCES EIGENSCHAFTEN (EIGENSCHAFTID)
                               );



CREATE TABLE REZEPT (
                     REZEPTNR			INTEGER NOT NULL,
                     REZEPTNAME          VARCHAR(50),
                     PRIMARY KEY (REZEPTNR)
);



CREATE TABLE BESTELLUNGSREZEPT (
                                BESTELLNR       INTEGER NOT NULL,
                                REZEPTNR        INTEGER,
                                MENGE     		INTEGER,
                                FOREIGN KEY (BESTELLNR) REFERENCES BESTELLUNG (BESTELLNR),
                                FOREIGN KEY (REZEPTNR) REFERENCES REZEPT (REZEPTNR)
);



CREATE TABLE REZEPTZUTAT (
                          REZEPTNR        INTEGER NOT NULL,
                          ZUTATNR         INTEGER NOT NULL,
                          MENGE           INTEGER,
                          FOREIGN KEY (REZEPTNR) REFERENCES REZEPT (REZEPTNR),
                          FOREIGN KEY (ZUTATNR) REFERENCES ZUTAT (ZUTATNR)
);

CREATE TABLE BESCHRAENKUNGEN (
                             BESCHRAENKUNGID INTEGER NOT NULL,
                             BESCHREIBUNG VARCHAR(50),
                             PRIMARY KEY (BESCHRAENKUNGID)
);

CREATE TABLE ZUTATBESCHRAENKUNG (
                                ZUTATNR INTEGER NOT NULL,
                                BESCHRAENKUNGID INTEGER NOT NULL,
                                FOREIGN KEY (ZUTATNR) REFERENCES ZUTAT (ZUTATNR),
                                FOREIGN KEY (BESCHRAENKUNGID) REFERENCES BESCHRAENKUNGEN (BESCHRAENKUNGID)
);