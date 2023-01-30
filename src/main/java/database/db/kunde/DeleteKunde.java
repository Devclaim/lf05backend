package database.db.kunde;

import database.DatabaseException;

public interface DeleteKunde {
    String deleteKunde(int kundennr) throws DatabaseException;
}
