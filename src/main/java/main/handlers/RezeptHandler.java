package main.handlers;

import data_access_object.Rezept;
import data_access_object.RezeptKalorien;
import data_access_object.RezeptList;
import data_access_object.RezeptZutatAnzahl;
import database.DatabaseException;
import database.db.rezept.DBrezept;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("rezepte")
public class RezeptHandler {
    private final DBrezept dBrezept;

    public RezeptHandler(DBrezept dBrezept) {
        this.dBrezept = dBrezept;
    }

    private Rezept[] allRezept() throws DatabaseException {
        return dBrezept.getAllRezept();
    }

    private Rezept[] rezepteFromZutatnr(int zutatnr) throws DatabaseException {
        return dBrezept.getRezepteByZutat(zutatnr);
    }

    private Rezept[] rezeptFromRezeptNr(int rezeptnr) throws DatabaseException {
        return dBrezept.getRezeptByRezeptnr(rezeptnr);
    }

    private RezeptZutatAnzahl[] rezepteWhereZutatenAnzahlMax(int maxZutaten) throws DatabaseException {
        return dBrezept.getRezepteWhereZutatenAnzahlMax(maxZutaten);
    }

    private RezeptKalorien[] rezepteUnderMaxKalorien(int maxKalorien) throws DatabaseException {
        return dBrezept.getRezeptByMaxKalorien(maxKalorien);
    }

    private RezeptZutatAnzahl[] rezepteFromEigenschaft(String eigenschaft, int maxResults) throws DatabaseException {
        return dBrezept.getRezepteByEigenschaftName(eigenschaft, maxResults);
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetAll() throws DatabaseException {
        return new RezeptList(allRezept());
    }

    @GET
    @Path("zutat")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetRezepteByZutat(@QueryParam("zutatnr") int zutatnr) throws DatabaseException {
        return rezepteFromZutatnr(zutatnr);
    }

    @GET
    @Path("rezept")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("rezeptnr") int rezeptnr) throws DatabaseException {
        return rezeptFromRezeptNr(rezeptnr);
    }

    @GET
    @Path("kalorien")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetRezUnderMaxKal(@QueryParam("max") int maxKalorien) throws DatabaseException {
        return rezepteUnderMaxKalorien(maxKalorien);
    }

    @GET
    @Path("kategorien/max")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("eigenschaft") String eigenschaft, @QueryParam("max") int maxResults) throws DatabaseException {
        return rezepteFromEigenschaft(eigenschaft, maxResults);
    }

    @GET
    @Path("kategorien")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("eigenschaft") String eigenschaft) throws DatabaseException {
        return rezepteFromEigenschaft(eigenschaft, 100);
    }

    @GET
    @Path("zutatenanzahl")
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGetWhereZutatenAnzahlMax(@QueryParam("max") int max) throws DatabaseException {
        return rezepteWhereZutatenAnzahlMax(max);
    }

}
