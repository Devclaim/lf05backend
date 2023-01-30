package database.db.bestellungskunde;

import data_access_object.Bestellungskunde;
import data_access_object.Naehrwerte;
import database.DatabaseException;

public interface GetBestellungskunde {
    Bestellungskunde[] getAllBestellungskunde() throws DatabaseException;

    Naehrwerte getNaehrwerteFromKundennr(int kundennr) throws DatabaseException;
}
