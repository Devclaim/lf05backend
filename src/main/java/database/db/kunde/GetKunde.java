package database.db.kunde;

import data_access_object.Kunde;
import database.DatabaseException;

public interface GetKunde {


    Kunde getKundeByKundennr(int kundennr) throws DatabaseException;

    Kunde[] getAllKunde() throws DatabaseException;

    Kunde[] getKundenByRegion(String plz) throws DatabaseException;
}