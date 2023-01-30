package main.handlers;

import data_access_object.Bestellungskunde;
import data_access_object.BestellungskundeList;
import data_access_object.Naehrwerte;
import database.DatabaseException;
import database.db.bestellungskunde.DBbestellungskunde;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("bestellungskunden")

public class BestellungskundeHandler {

    private final DBbestellungskunde dBbestellungskunde;

    public BestellungskundeHandler(DBbestellungskunde dBbestellungskunde) {
        this.dBbestellungskunde = dBbestellungskunde;
    }

    private Bestellungskunde[] allBestellungskunde() throws DatabaseException {
        return dBbestellungskunde.getAllBestellungskunde();
    }

    private Naehrwerte avgNaehrwerte(int kundennr) throws DatabaseException {
        return dBbestellungskunde.getNaehrwerteFromKundennr(kundennr);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetAllBestellungskunde() throws DatabaseException {
        return new BestellungskundeList(allBestellungskunde());
    }

    @GET
    @Path("naehrwert")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetAvgNaehrwerte(@QueryParam("kundennr") int kundennr) throws DatabaseException {
        return avgNaehrwerte(kundennr);
    }
}
