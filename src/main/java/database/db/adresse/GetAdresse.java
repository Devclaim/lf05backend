package database.db.adresse;

import data_access_object.Adresse;
import database.DatabaseException;

public interface GetAdresse {
    Adresse getAdresseByKundennr(int kundennr) throws DatabaseException;

    Adresse[] getAllAdresse() throws DatabaseException;
}