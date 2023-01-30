# LF05Backend (Kilian S. / Hakon T. / Burhan K.)

## Pfad der SQL DB und Statements

**JOOQ SQL QUERYS -> src/main/java/database/db -> "Package" -> "Class"DAO**

**Inital Tables Ressource -> src/main/resources/InitalTables.sql**

**Inital DB-DATA Ressource -> src/main/resources/DataRessource.sql**

## Datenbank selber testen

1.  Git Clone
2.  Main.Java ausführen
3.  Option wählen: 
    * OHNE FRONTEND: Queries in der Browser-Suchleiste eingeben 
    * MIT FRONTEND: Frontend- Applikation starten
   
### Frontend:
https://github.com/Devclaim/lf05frontend

## Queries

### Kunden

###### GET byNr [Query param: int kundennr]
```
http://localhost:8081/kunden/?kundennr={kundennr}
```

###### GET all
```
http://localhost:8081/kunden/all
```

###### POST new Kunde [{"kundennr": int,"nachname": "String","vorname": "String","geburtsdatum": [JJJJ,MM,DD],"adressid": int}]
```
http://localhost:8081/kunden/new
```

###### GET delete Kunde [Query Param: int kundennr]
```
http://localhost:8081/kunden/delete/?kundennr={kundennr}
```

###### GET byRegion [Query Param: int plz]
```
http://localhost:8081/kunden/region/?plz={plz}
```

### Zutaten

###### GET all
```
http://localhost:8081/zutaten/all
```

###### GET allCO2Ranked
```
http://localhost:8081/zutaten/co2
```

###### GET byRezeptNr [Query Param: int rezeptnr]
```
http://localhost:8081/zutaten/?rezeptnr={rezeptnr}
```

###### GET byRezeptName [Query Param: String rezeptname]
```
http://localhost:8081/zutaten/byrezept/?rezeptname={rezeptname}
```

###### GET unusedFromRezepte
```
http://localhost:8081/zutaten/unused
```

### Rezepte

###### GET byNr [Query Param: int rezeptnr]
```
http://localhost:8081/rezepte/rezept/?rezeptnr={rezeptnr}
```

###### GET all
```
http://localhost:8081/rezepte/all
```

###### GET byZutatNr [Query Param: int zutatnr]
```
http://localhost:8081/rezepte/zutat/?zutatnr={zutatnr}
```

###### GET byMaxKalorien [Query Param: int maxKalorien]
```
http://localhost:8081/rezepte/kalorien/?max={maxKalorien}
```

###### GET byKategorie [Query Param: String eigenschaft]
```
http://localhost:8081/rezepte/kategorien/?eigenschaft=
```

###### GET byKategorieAndMax [Query Params: String eigenschaft, int max]
```
http://localhost:8081/rezepte/kategorien/max/?eigenschaft={eigenschaft}&max={max}
```

###### GET withMaxZutatenAnzahl [Query Param: int max]
```
http://localhost:8081/rezepte/zutatenanzahl/?max={max}
```

### Adresse

###### GET byKundenNr Query [Query Params: int kundennr]
```
http://localhost:8081/adressen/?kundennr={kundennr}
```

###### GET all
```
http://localhost:8081/adressen/all
```


### Bestellungskunde

###### GET all
```
http://localhost:8081/bestellungskunden/all
```

###### GET getNaehrwerteByKundennr [Query Param: int kundennr]
```
http://localhost:8081/bestellungskunden/naehrwert/?kundennr={kundennr}
```

Build with Gradle

Backend Dependencies -> build.gradle

