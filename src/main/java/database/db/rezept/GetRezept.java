package database.db.rezept;

import data_access_object.Rezept;
import data_access_object.RezeptKalorien;
import data_access_object.RezeptZutatAnzahl;
import database.DatabaseException;

public interface GetRezept {

    Rezept[] getAllRezept() throws DatabaseException;
    Rezept[] getRezepteByZutat(int zutatnr) throws DatabaseException;
    Rezept[] getRezeptByRezeptnr(int rezeptnr) throws DatabaseException;
    RezeptKalorien[] getRezeptByMaxKalorien(int maxKalorien);
    RezeptZutatAnzahl[] getRezepteByEigenschaftName(String bezeichnung, int maxResults) throws DatabaseException;
    RezeptZutatAnzahl[] getRezepteWhereZutatenAnzahlMax(int maxZutaten);
}
