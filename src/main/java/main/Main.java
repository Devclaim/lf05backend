package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import database.data.KuRDatabase;
import database.data.PGWriter;
import database.db.adresse.AdresseDAO;
import database.db.bestellungskunde.BestellungskundeDAO;
import database.db.kunde.KundeDAO;
import database.db.rezept.RezeptDAO;
import database.db.zutat.ZutatDAO;
import main.handlers.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


public class Main {
    static Server dbServer;
    public static void main(String[] args) throws Exception {

        new MainFrame();

        var dataSource = KuRDatabase.create();
        try (var connection = dataSource.getConnection()) {
            PGWriter.initalizeTables(connection);
            PGWriter.writeResource(connection);
        }

        dbServer = new Server(8081);

        ResourceConfig resConfig = new ResourceConfig();

        resConfig.register(new KundeHandler(new KundeDAO(() -> DSL.using(dataSource, SQLDialect.POSTGRES))));
        resConfig.register(new ZutatHandler(new ZutatDAO(() -> DSL.using(dataSource, SQLDialect.POSTGRES))));
        resConfig.register(new RezeptHandler(new RezeptDAO(() -> DSL.using(dataSource, SQLDialect.POSTGRES))));
        resConfig.register(new AdresseHandler(new AdresseDAO(() -> DSL.using(dataSource, SQLDialect.POSTGRES))));
        resConfig.register(new BestellungskundeHandler(new BestellungskundeDAO(() -> DSL.using(dataSource, SQLDialect.POSTGRES))));

        JacksonJsonProvider component = new JacksonJsonProvider();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        component.setMapper(objectMapper);
        resConfig.register(component);
        final ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        dbServer.setHandler(servletContextHandler);
        servletContextHandler.addServlet(
                new ServletHolder(new ServletContainer(resConfig)),
                "/*"
        );
        dbServer.start();
        dbServer.join();  
    }
}