package database.db.zutat;

import data_access_object.Zutat;
import database.DatabaseException;

public interface GetZutat {

    Zutat[] getAll() throws DatabaseException;

    Zutat[] getByRezept(int rezeptnr) throws DatabaseException;

    Zutat[] getZutatenNotContainedInAnyRezept() throws DatabaseException;

    Zutat[] getZutatenByRezeptName(String rezeptName);
    Zutat[] getZutatenRankedByCO2();
}
