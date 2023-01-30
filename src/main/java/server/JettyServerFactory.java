package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServerFactory {
    private JettyServerFactory() {
    }

    public static JettyServer create(int port, Class<?> endpointClass) {
        final Server server = new Server(port);
        final ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);
        ServletHolder jerseyServlet = servletContextHandler.addServlet(
                ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames", endpointClass.getCanonicalName());

        return new JettyServer(server);
    }
}
