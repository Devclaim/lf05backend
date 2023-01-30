package database.db.kunde;

import data_access_object.Kunde;
import database.DatabaseException;

public interface InsertKunde {
    void insertKunde(Kunde kunde) throws DatabaseException;
}
