package main.handlers;

import database.DatabaseException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public class SQLHandler {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object doGet(@QueryParam("sql") String sql) throws DatabaseException {
        return sql;
    }

}
