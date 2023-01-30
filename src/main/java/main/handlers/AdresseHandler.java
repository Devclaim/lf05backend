package main.handlers;

import data_access_object.Adresse;
import database.DatabaseException;
import database.db.adresse.DBadresse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("adressen")
public class AdresseHandler {

    private final DBadresse dBadresse;

    public AdresseHandler(DBadresse dBadresse) {
        this.dBadresse = dBadresse;
    }

    private Adresse adresseFromKundennr(int kundennr) throws DatabaseException {
        return dBadresse.getAdresseByKundennr(kundennr);
    }

    private Adresse[] allAdresse() throws DatabaseException {
        return dBadresse.getAllAdresse();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("kundennr") int kundennr) throws DatabaseException {
        return adresseFromKundennr(kundennr);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet() throws DatabaseException {
        return allAdresse();
    }
}
