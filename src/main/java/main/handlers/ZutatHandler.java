package main.handlers;

import data_access_object.Zutat;
import database.DatabaseException;
import database.db.zutat.DBzutat;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path(("zutaten"))
public class ZutatHandler {
    private final DBzutat dBzutat;

    public ZutatHandler(DBzutat dBzutat) {
        this.dBzutat = dBzutat;
    }

    private Zutat[] allZutaten() throws DatabaseException {
        return dBzutat.getAll();
    }

    private Zutat[] zutatenFromRezept(int rezeptnr) throws DatabaseException {
        return dBzutat.getByRezept(rezeptnr);
    }

    private Zutat[] zutatenNotContainedInAnyRezept() throws DatabaseException {
        return dBzutat.getZutatenNotContainedInAnyRezept();
    }

    private Zutat[] zutatenFromRezeptName(String rezeptName) throws DatabaseException {
        return dBzutat.getZutatenByRezeptName(rezeptName);
    }

    private Zutat[] zutatenCO2Ranked() throws DatabaseException {
        return dBzutat.getZutatenRankedByCO2();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetAll() throws DatabaseException {
        return allZutaten();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("rezeptnr") int rezeptnr) throws DatabaseException {
        return zutatenFromRezept(rezeptnr);
    }

    @GET
    @Path("unused")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetUnused() throws DatabaseException {
        return zutatenNotContainedInAnyRezept();
    }

    @GET
    @Path("byrezept")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("rezeptname") String rezeptname) throws DatabaseException {
        return zutatenFromRezeptName(rezeptname);
    }

    @GET
    @Path("co2")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetCO2Ranked() throws DatabaseException {
        return zutatenCO2Ranked();
    }

}