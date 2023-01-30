package main.handlers;

import data_access_object.Kunde;
import data_access_object.KundeList;
import database.DatabaseException;
import database.db.kunde.DBkunde;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("kunden")
public class KundeHandler {

    private final DBkunde dBkunde;

    public KundeHandler(DBkunde dBkunde) {
        this.dBkunde = dBkunde;
    }

    private Kunde kundeFromKundennr(int kundennr) throws DatabaseException {
        return dBkunde.getKundeByKundennr(kundennr);
    }

    private Kunde[] allKunde() throws DatabaseException {
        return dBkunde.getAllKunde();
    }

    private String deleteKunde(int kundennr) throws DatabaseException {
        return dBkunde.deleteKunde(kundennr);
    }

    private Kunde[] kundenInRegion(String plz) throws DatabaseException {
        return dBkunde.getKundenByRegion(plz);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("kundennr") int kundennr) throws DatabaseException {
        return kundeFromKundennr(kundennr);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet() throws DatabaseException {
        return new KundeList(allKunde());
    }

    @POST
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object doPost(Kunde kunde) throws DatabaseException {
        dBkunde.insertKunde(kunde);
        return kunde;
    }

    @GET
    @Path("delete")
    public Object doDelete(@QueryParam("kundennr") int kundennr) throws DatabaseException {
        return deleteKunde(kundennr);
    }

    @GET
    @Path("region")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetByRegion(@QueryParam("plz") String plz) throws DatabaseException {
        return kundenInRegion(plz);
    }
}
